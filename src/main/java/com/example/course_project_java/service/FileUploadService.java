package com.example.course_project_java.service;

import com.example.course_project_java.models.Data;
import com.example.course_project_java.repository.DataRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class FileUploadService {

    public static void uploadFileToDatabase(DataRepository dataRepository, MultipartFile file) {
        dataRepository.deleteAll();
        if (!file.isEmpty()) {
            BufferedReader br;
            Data data;
            try {
                String line;
                InputStream is = file.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                line = br.readLine().strip();
                if (line.equals("customer_id,tr_datetime,mcc_code,tr_type,amount,term_id")) {
                    while ((line = br.readLine()) != null) {
                        String[] str = line.split(",");
                        Double amount = Double.parseDouble(str[4]);
                        data = new Data(str[2], str[3], amount);
                        dataRepository.save(data);
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }else
        {
            System.out.println("Файл пустой");
        }
    }
}
