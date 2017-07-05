package me.songt.artsharing.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by tony on 2017/6/27.
 */
public class FileHelper
{
//    private final Logger logger = LoggerFactory.getLogger(FileHelper.class);

    //Full abs path
    public static String fullAbsPath = System.getProperty("user.home") + "/artsharing";

    public static String createMd5OfMultipartFile(final MultipartFile file) throws NoSuchAlgorithmException, IOException
    {
        StringBuilder builder = new StringBuilder();
        MessageDigest md5 = null;
        md5 = MessageDigest.getInstance("md5");
        InputStream stream = file.getInputStream();
        int available = stream.available();
        byte[] bytes = new byte[available];
        md5.update(bytes);
        for (byte byt : md5.digest())
        {
            builder.append(String.format("%02X", byt));
        }
        return builder.toString();
    }

    /*public static String getFullFilePath(final MultipartFile multipartFile) throws NoSuchAlgorithmException, IOException
    {
        String fileName = multipartFile.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.indexOf('.'));
        String fileMd5 = createMd5OfMultipartFile(multipartFile);
        String fullFileName = fileMd5 + fileExtension;
        String fullFilePath = Paths.get(fullAbsPath + fullFileName).toString();
        return fullFilePath;
    }*/

    /*public void saveFile(final MultipartFile file) throws NoSuchAlgorithmException, IOException
    {
        String fullFilePath = getFullFilePath(file);

        //Check if the folder exists
        File fileDirectory = new File(fullAbsPath);
        if (!fileDirectory.exists())
        {
            if (!fileDirectory.mkdir())
            {
                logger.warn("Folder Create Failed. Path: " + fullAbsPath);
            }
        }
        //Write File
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullFilePath)));
        stream.write(file.getBytes());
        stream.close();
    }*/
}
