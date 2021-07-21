package com.loti.controller.Utils;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class FileUtils {
    public static String UploadFile(MultipartFile file){
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String fileName = UUID.randomUUID() + String.valueOf(file.getOriginalFilename().hashCode());

        String url_path = "img" + File.separator + "studentPhoto" + File.separator + fileName;
        String save_path = staticPath + File.separator + url_path;

        File saveFile = new File(save_path);
        if (!saveFile.exists()){
            saveFile.mkdirs();
        }

        try {
            file.transferTo(saveFile);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

        return "static/" + url_path;
    }
}
