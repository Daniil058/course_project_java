package com.example.course_project_java.utils;
import javax.servlet.ServletContext;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class MediaTypeUtils {

    public static MediaType getMediaTypeForFileName(
            ServletContext servletContext,
            String fileName
    ) {
        String mineType = servletContext.getMimeType(fileName);
        try {
            return MediaType.parseMediaType(mineType);
        } catch (Exception e) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
}