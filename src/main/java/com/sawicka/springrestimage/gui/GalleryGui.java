package com.sawicka.springrestimage.gui;

import com.sawicka.springrestimage.entities.Image;
import com.sawicka.springrestimage.repositories.ImageRepo;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("gallery")
public class GalleryGui extends VerticalLayout {

    private ImageRepo imageRepo;

    @Autowired
    public GalleryGui(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;

        List<Image> allImages = imageRepo.findAll();
        allImages.stream().forEach(element -> {
            com.vaadin.flow.component.html.Image image =
                    new com.vaadin.flow.component.html.Image(element.getImageAddress(), "empty");
            add(image);
        });

    }

}
