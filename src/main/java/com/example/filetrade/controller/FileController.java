package com.example.filetrade.controller;

import com.alibaba.fastjson.JSON;
import com.example.filetrade.entity.FileBean;
import com.example.filetrade.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    //upload
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("json") String json,
                       @RequestParam("file") MultipartFile multipartFile){

        FileBean fileBean = JSON.parseObject(json,FileBean.class);
        File file = new File(fileBean.getURL());
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(file);
            fileBean.setSize(FileBean.convertFileSize(file.length()));
            int t= fileService.upload(fileBean);
            return ((t==1)?"success":"fail");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    //download
    @RequestMapping(value = "/download/{url}",method = RequestMethod.GET)
    public String downloadFile(HttpServletResponse response, @PathVariable String url)  throws Exception {

        File file = new File(FileBean.URL + url);

        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.setHeader("Content-Disposition", "attachment");
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "fail";
    }
}
