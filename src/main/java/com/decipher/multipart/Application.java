package com.decipher.multipart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class Application {

   private static String UPLOADED_FOLDER = "/home/dz-jp-11/Documents/shubham saini/multipart";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)

    public String singleFileUpload(@RequestParam("file") MultipartFile[] file) {
        for (MultipartFile multipartFile : file) {
            try {
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + multipartFile.getOriginalFilename());
                Files.write(path, bytes);
                return uploadStatus1()+multipartFile.getOriginalFilename();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/uploadStatus";
    }
    @RequestMapping("/uploadStatus")
    public String uploadStatus1(){
        return "file not uploaded";
    }
}
