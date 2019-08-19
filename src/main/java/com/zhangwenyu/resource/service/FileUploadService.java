package com.zhangwenyu.resource.service;


import org.springframework.web.multipart.MultipartFile;




import java.io.IOException;



public interface FileUploadService {

     int imageUpload(MultipartFile images, String filePath,String name) throws IOException ;
}
