package com.xenenergy.projects.entities;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by xesi on 14/09/2017.
 */
public class UploadLogo {
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
