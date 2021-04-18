package com.wong.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * 控制器（理解为 相当于 WEB 阶段的 Servlet）
 */
@Controller
public class UploadController {
    /**
     * 文件上传
     */
    //    @RequestMapping("upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) {
        //具体文件上传代码
        //文件名称使用32位字符串 解决文件名重名问题
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println("uuid = " + uuid);
        
        //获取上传文件的文件名
        String filename = uploadFile.getOriginalFilename();
        System.out.println("filename = " + filename);
        System.out.println("上传的文件名称 = " + uuid + filename);
        
        //指定文件保存到服务器的位置
        //        String contextPath = request.getContextPath();
        //        System.out.println("contextPath = " + contextPath);
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println("realPath = " + realPath);
        File path = new File(realPath, uuid + filename);
        
        //进行文件上传
        try {
            uploadFile.transferTo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return "result";
    }
    
    /**
     * 跨服务器上传
     */
    @RequestMapping("upload")
    public String uploadFile(MultipartFile uploadFile, HttpServletRequest request) {
        //具体文件上传代码
        //文件名称使用32位字符串 解决文件名重名问题
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println("跨服务器文件上传 uuid = " + uuid);
        
        //获取上传文件的文件名
        String filename = uploadFile.getOriginalFilename();
        System.out.println("filename = " + filename);
        System.out.println("跨服务器文件上传 上传的文件名称 = " + uuid + filename);
        
        //指定文件保存到服务器的位置
        String path = "http://localhost:8082/spring_mvc_01_helloworld/upload";
        
        //进行文件上传
        //创建一个跨服务器上传文件的 客户端对象
        Client client = Client.create();
        //指定要上传的文件资源
        WebResource resource = client.resource(path + "/" + uuid + filename);
        //执行上传文件
        try {
            resource.put(String.class, uploadFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return "result";
    }
}