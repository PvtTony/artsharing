package me.songt.artsharing.controller;

import me.songt.artsharing.po.ArtEntity;
import me.songt.artsharing.service.ArtService;
import me.songt.artsharing.utils.FileHelper;
import me.songt.artsharing.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;

/**
 * Created by tony on 2017/6/27.
 */
@RestController
public class ArtController
{
    @Autowired
    private ArtService artService;

    private final ResourceLoader resourceLoader;

    @Autowired
    public ArtController(ResourceLoader resourceLoader)
    {
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("/api/art/upload")
    public ResponseEntity<?> uploadArt(@RequestParam(required = true) int userId,
                                       @RequestParam(required = true) String artName,
                                       @RequestParam(required = true) MultipartFile uploadFile)
    {
        Result result = artService.upload(artName, userId, uploadFile);
        if (!result.isSuccess())
        {
            return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename)
    {
        try
        {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(FileHelper.fullAbsPath, filename).toString()));
        } catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/art/userId/{userId}")
    public ResponseEntity<?> getAllArts(@PathVariable("userId") int userId,
                                        @RequestParam(defaultValue = "id") String sortField,
                                        @RequestParam(defaultValue = "0") int pageIndex,
                                        @RequestParam(defaultValue = "10") int pageSize,
                                        @RequestParam(defaultValue = "1") int desc)
    {
        Page<ArtEntity> artEntities = artService.getAllUserArts(userId, sortField, pageIndex, pageSize, desc == 1);
        return new ResponseEntity<Object>(artEntities, HttpStatus.OK);
    }
}
