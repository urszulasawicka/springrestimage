package com.sawicka.springrestimage;

import com.cloudinary.Cloudinary;
import com.sawicka.springrestimage.repositories.ImageRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ImageUploaderTest {

    @Mock
    Cloudinary cloudinary;

    @Mock
    ImageRepo imageRepo;

    @InjectMocks
    ImageUploader imageUploader;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void givenInvalidPath_whenUploadFileSaveToDB_thenEmpty() {
        //Given
        imageUploader = new ImageUploader(imageRepo);

        //When
        String url = imageUploader.uploadFileSaveToDB(null);

        //Then
        Assertions.assertNull(url);
    }
}