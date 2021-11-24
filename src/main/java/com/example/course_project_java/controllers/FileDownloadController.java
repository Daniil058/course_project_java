package com.example.course_project_java.controllers;

import javax.servlet.ServletContext;

import com.example.course_project_java.utils.MediaTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class FileDownloadController {

    private static final String DIRECTORY = "src/main/resources/static";
    private static final String DEFAULT_FILE_NAME = "new_file.csv";

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/download")
    public ResponseEntity<InputStreamResource> downloadFile(
            @RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName
    ) throws IOException
    {
        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
        File file = new File(DIRECTORY + "/" + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(mediaType)
                .contentLength(file.length())
                .body(resource);
    }

}
