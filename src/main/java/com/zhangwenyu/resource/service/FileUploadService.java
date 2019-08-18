package com.zhangwenyu.resource.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileUploadService {

    public int imageUpload(MultipartFile images, String filePath,String name) throws IOException {

        File saveDir = new File(filePath);
        if(!saveDir.getParentFile().exists()){
            saveDir.getParentFile().mkdirs();
        }
        images.transferTo(new File(filePath,name));
        return 1;
    }
}
