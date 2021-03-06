package com.sawicka.springrestimage.gui;

import com.sawicka.springrestimage.ImageUploader;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("uploadImage")
public class UploadGui extends VerticalLayout {

    private ImageUploader imageUploader;

    @Autowired
    public UploadGui(ImageUploader imageUploader) {
        this.imageUploader = imageUploader;

        Label label = new Label();
        TextField textField = new TextField();
        Button button = new Button("Upload");
        button.addClickListener(buttonClickEvent ->
        {
            String imageLocation = imageUploader.uploadFile(textField.getValue());
            Image image = null;
            if (imageLocation != null) {
                label.setText("Picture uploaded!");
                image = new Image(imageLocation, "Empty picture!!!");
            } else {
                label.setText("Empty file path!!!");
            }

            add(label);
            if (image != null) {
                add(image);
            }
        });

        add(textField);
        add(button);
    }

}
