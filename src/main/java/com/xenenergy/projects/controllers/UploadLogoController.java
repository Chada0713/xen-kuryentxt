package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.UploadLogo;
import com.xenenergy.projects.services.interfaces.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by xesi on 13/09/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/updloadlogo")
public class UploadLogoController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(method = RequestMethod.GET)
    public String showLogoPage(Model model){
        model.addAttribute("uploadLogo", new UploadLogo());
        return "uploadlogo/index";
    }

    @PostMapping("/savelogo")
    public String savelogo(UploadLogo uploadLogo, @RequestParam("file") MultipartFile file,
                           final RedirectAttributes redirectAttributes){
        System.out.println("Image Path: " + uploadLogo.getImagePath() + " - " + file);
        String imageFile = uploadFile(file);
        String imageFileTomcat = uploadFileForTomcat(file);

        return "redirect:/";
    }

    private String uploadFile(MultipartFile file){
        if(!file.isEmpty()){
            try{
                byte[] bytes = file.getBytes();
                // Creating the directory to store file
                String rootPath = "C:\\Kuryentxtweb\\ext\\";// System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator); // + "images"
                if(!dir.exists()){
                    dir.mkdirs();
                }

                // Create the file on server
                String name = String.valueOf("logo.png");
                File serverFile = new File(dir.getAbsolutePath() + File.separator + name); //File.separator

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

                stream.write(bytes);
                stream.close();
                return name;
            }catch(Exception e){

            }
        }
        return null;
    }

    private String uploadFileForTomcat(MultipartFile file){
        if(!file.isEmpty()){
            try{
                byte[] bytes = file.getBytes();
                // Creating the directory to store file

                String tomcatPath = propertyService.findByPropertyName("TOMCAT_PATH").getPropertyValue();
                File dir = new File(tomcatPath + File.separator + "images");
                if(!dir.exists()){
                    dir.mkdirs();
                }

                // Create the file on server
                String name = String.valueOf("logo.png");
                File serverFileCatalina = new File(dir.getAbsolutePath() + File.separator + name);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFileCatalina));

                stream.write(bytes);
                stream.close();
                return name;
            }catch(Exception e){

            }
        }
        return null;
    }
}
