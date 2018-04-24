package com.xiyan.controller;

import com.alibaba.fastjson.JSON;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.utils.FileUploadUtil;
import com.xiyan.utils.ImgCut;
import com.xiyan.utils.PropertiesUtil;
import com.xiyan.utils.QiniuUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

@RestController
@RequestMapping("/image")
public class ImageController {
    @RequestMapping(value = "/uploadheadimage", method = RequestMethod.POST)
    public String uploadHeadImage(@RequestParam(value = "x") String x,
                                  @RequestParam(value = "y") String y,
                                  @RequestParam(value = "h") String h,
                                  @RequestParam(value = "w") String w,
                                  @RequestParam(value = "imgFile") MultipartFile imageFile,
                                  String name) throws Exception {
        String resourcePath = PropertiesUtil.getProp("resources.path");
        if (imageFile != null) {
            if (FileUploadUtil.allowUpload(imageFile.getContentType())) {
                File dir = new File(resourcePath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                Date date = new Date();
                String saveName = "" + date.getTime();
                File file = new File(dir, saveName + ".jpg");
                imageFile.transferTo(file);
                String srcImagePath = resourcePath + saveName;
                int imageX = Integer.parseInt(x);
                int imageY = Integer.parseInt(y);
                int imageH = Integer.parseInt(h);
                int imageW = Integer.parseInt(w);
                //这里开始截取操作
                System.out.println("==========imageCutStart=============");
                ImgCut.imgCut(srcImagePath, imageX, imageY, imageW, imageH);
                System.out.println("==========imageCutEnd=============");
                String result="";
                if (name.equals(""))
                    result=QiniuUtil.upload(new File(srcImagePath + "_cut.jpg"));
                else
                    result=QiniuUtil.upload(new File(srcImagePath + "_cut.jpg"),name);

                return JSON.toJSONString(APIResponse.returnSuccess(result));
            }
        }
        return JSON.toJSONString(APIResponse.returnFail(""));
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "imgFile") MultipartFile imageFile,String name) throws Exception {

        String resourcePath = PropertiesUtil.getProp("resources.path");
        //如果文件不为空，写入上传路径
        if (!imageFile.isEmpty()) {
            if (FileUploadUtil.allowUpload(imageFile.getContentType())) {
                File dir = new File(resourcePath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                Date date = new Date();
                String saveName = "" + date.getTime();
                File file = new File(dir, saveName + ".jpg");
                imageFile.transferTo(file);
                String result="";
                if (name.equals(""))
                    result=QiniuUtil.upload(file);
                else
                    result=QiniuUtil.upload(file ,name);
                return JSON.toJSONString(APIResponse.returnSuccess(result));
            }
        }
        return JSON.toJSONString(APIResponse.returnFail(""));
    }

    @RequestMapping(value = "/getimage")
    @ResponseBody
    public String createFolw(
                             HttpServletResponse response, String url) {
        // response.setContentType("image/*");
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            fis = new FileInputStream(url);
            os = response.getOutputStream();
            int count = 0;
            byte[] buffer = new byte[1024 * 8];
            while ((count = fis.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fis.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
