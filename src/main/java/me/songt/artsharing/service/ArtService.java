package me.songt.artsharing.service;

import me.songt.artsharing.po.ArtEntity;
import me.songt.artsharing.vo.ArtViewModel;
import me.songt.artsharing.vo.Result;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by tony on 2017/6/27.
 */
@Service
public interface ArtService
{
    Result upload(String artName, int userId, MultipartFile multipartFile);

    List<ArtViewModel> getAllUserArts(int userId, String sortField, int pageIndex, int pageSize, boolean desc);

    ArtViewModel getArtById(int artId);

    Result delete(ArtEntity artEntity);


}
