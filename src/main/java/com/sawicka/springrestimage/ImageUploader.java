package com.sawicka.springrestimage;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.sawicka.springrestimage.entities.Image;
import com.sawicka.springrestimage.repositories.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {

    private Cloudinary cloudinary;

    private ImageRepo imageRepo;

    @Autowired
    public ImageUploader(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "xxx",
                "api_key", "xxx",
                "api_secret", "xxx"
        ));
    }

    public String uploadFileSaveToDB(String path) {
        if (path == null || path.isEmpty() || path.isBlank()) {
            return null;
        }

        File file = new File(path);
        Map uploadResult = null;
        String url = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            url = uploadResult.get("url").toString();
            imageRepo.save(new Image(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

}
