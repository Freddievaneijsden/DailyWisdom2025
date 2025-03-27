package com.example.dailywisdom2025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    // Show the upload form when visiting /uploadimage
    @GetMapping("/uploadimage")
    public String displayUploadForm() {
        return "imageupload/index";
    }

    // Prevent GET requests to /upload from causing errors
    @GetMapping("/upload")
    public String redirectToUploadForm() {
        return "redirect:/uploadimage"; // Redirects to the upload form instead of throwing an error
    }

    @PostMapping("/upload") public String uploadImage(Model model, @RequestParam("image") MultipartFile file) throws IOException {
        // Ensure the uploads directory exists
        Path uploadDir = Paths.get(UPLOAD_DIRECTORY);
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir); // Create directory if it does not exist
        }

        if (file.isEmpty()) {
            model.addAttribute("msg", "Please select an image to upload.");
            return "imageupload/index";
        }

        // Save the file
        Path fileNameAndPath = uploadDir.resolve(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());

        model.addAttribute("msg", "Uploaded image: " + file.getOriginalFilename());
        return "imageupload/index"; // Show form again with success message
    }
}
