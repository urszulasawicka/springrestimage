package com.sawicka.springrestimage;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {

    private Cloudinary cloudinary;

    public ImageUploader() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "xxx",
                "api_key", "xxx",
                "api_secret", "xxx"
        ));
    }

    public String uploadFile(String path) {
        if (path == null || path.isEmpty() || path.isBlank()) {
            return null;
        }

        File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadResult.get("url").toString();
    }

}
