package com.wong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 控制器（理解为 相当于 WEB 阶段的 Servlet）
 */
@Controller
public class UploadController {
    @RequestMapping("upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) {
        //具体文件上传代码
        //获取上传文件的文件名
        String filename = uploadFile.getOriginalFilename();
        System.out.println("filename = " + filename);

        //指定文件保存到服务器的位置
        String realPath = request.getSession().getServletContext().getRealPath(request.getContextPath() + "/upload");
        System.out.println("realPath = " + realPath);
        File path = new File(realPath, filename);

        //进行文件上传
        try {
            uploadFile.transferTo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "result";
    }
}