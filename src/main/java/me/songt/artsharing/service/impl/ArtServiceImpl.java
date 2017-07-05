package me.songt.artsharing.service.impl;

import me.songt.artsharing.dao.ArtRepository;
import me.songt.artsharing.po.ArtEntity;
import me.songt.artsharing.service.ArtService;
import me.songt.artsharing.utils.FileHelper;
import me.songt.artsharing.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

/**
 * Created by tony on 2017/6/27.
 */
@Service
public class ArtServiceImpl implements ArtService
{
    //Logger
    private final Logger logger = LoggerFactory.getLogger(ArtServiceImpl.class);

    //Art Repository
    @Autowired
    private ArtRepository artRepository;

    @Override
    public Result upload(String artName, int userId, MultipartFile multipartFile)
    {
        //Initial art entity
        ArtEntity artEntity = new ArtEntity();
        artEntity.setArtAuthor(userId);
        artEntity.setArtName(artName);

        //Result
        Result result;
        //Prompt
        String prompt;

        String fileName = multipartFile.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.indexOf('.'));
        //Save Art
        try
        {
            String md5FileName = FileHelper.createMd5OfMultipartFile(multipartFile);
            String fullFileName = md5FileName + fileExtension;
            Files.copy(multipartFile.getInputStream(), Paths.get(FileHelper.fullAbsPath, fullFileName));
//            helper.saveFile(multipartFile);
            //Get Multipart File Info
//            artEntity.setArtPath(helper.getFullFilePath(multipartFile));
            //Save art
            artEntity.setArtPath(fullFileName);
        } catch (NoSuchAlgorithmException e)
        {
            prompt = "File Upload Failed. No MD5 Algorithm";
            logger.error(prompt);
            result = new Result(false, prompt, null);
            e.printStackTrace();
            return result;

        } catch (IOException e)
        {
            prompt = "File Upload Failed. IO Exception";
            logger.error(prompt);
            result = new Result(false, prompt, null);
            e.printStackTrace();
            return result;
        }
        artRepository.save(artEntity);
        result = new Result(true, "Save success", artEntity);
        return result;
    }

    @Override
    public Page<ArtEntity> getAllUserArts(int userId, String sortField, int pageIndex, int pageSize, boolean desc)
    {
        Page<ArtEntity> artEntities = artRepository.findAllByArtAuthor(userId,
                new PageRequest(pageIndex,
                        pageSize,
                        new Sort(desc ? Sort.Direction.DESC : Sort.Direction.ASC, sortField)));
        return artEntities;
    }

    @Override
    public ArtEntity getArtById(int artId)
    {
        ArtEntity entity = artRepository.findOne(artId);
        return entity;
    }

    @Override
    public Result delete(ArtEntity artEntity)
    {
        if (artEntity != null)
        {
            artRepository.delete(artEntity);
        }
        return new Result(true, "Delete success", null);
    }
}
