package com.example.course_project_java.service;

import com.example.course_project_java.entity.Data;
import com.example.course_project_java.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FileUploadService {

    final static Logger logger = LoggerFactory.getLogger(FileUploadService.class);

    private final DataRepository dataRepository;

    @Autowired
    public FileUploadService(
            DataRepository dataRepository
    ){
        this.dataRepository = dataRepository;
    }

    public void uploadFileToDatabase(
            MultipartFile file
    ) {
        dataRepository.deleteAll();
        if (file.isEmpty()) {
            logger.debug("Файл пустой");
            return;
        }
        BufferedReader br;
        Data data;
        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            line = br.readLine().strip();
            if (!line.equals("customer_id,tr_datetime,mcc_code,tr_type,amount,term_id")) {
                logger.debug("При загрузке файла произошла ошибка:" +
                        " Не обноружено название столбцов во входном файле.");
                return;
            }
            while ((line = br.readLine()) != null) {
                String[] str = line.split(",");
                BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(str[4]));
                data = new Data(str[2], str[3], amount);
                dataRepository.save(data);
            }
        } catch (IOException e) {
            logger.debug("При загрузке файла произошла ошибка: " + e.getMessage());
        }
    }
}
