package com.qingcheng.controller.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 上传控制器
 */
@RestController
@RequestMapping("/upload")
public class UploadController {
    /*想要读取path路径，需要接受request对象*/
    @Autowired
    private HttpServletRequest request;
    /*本地上传*/
    @PostMapping("/native")
    public String nativeUpload(@RequestParam("file") MultipartFile file){
            /*获得img目录的绝对路径*/
            String path = request.getSession().getServletContext().getRealPath("img");
            /*获得img目录和文件名，即文件的绝对路径*/
            String filePath = path + "/" +file.getOriginalFilename();
            /*有了文件的绝对路径，就可以构建文件对象了*/
            File desFile = new File(filePath);
           /* img目录不一定存在，所以需要做判断*/
            if (!desFile.getParentFile().exists()){
                /*如果不存在则创建目录*/
                desFile.mkdir();
            }
        try {
            file.transferTo(desFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*最后返回目录地址*/
        return "http://localhost:9101/img/"+file.getOriginalFilename();
    }
}
