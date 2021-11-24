package com.example.course_project_java.service;

import com.example.course_project_java.entity.Data;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class FileDownloadService {

    private final static String CSV_FILE = "src/main/resources/static/new_file.csv";

    final static Logger logger = LoggerFactory.getLogger(FileDownloadService.class);

    public void fileDownloadFromIterable(List<Data> list){
        try (PrintWriter writer = new PrintWriter(new File(CSV_FILE))) {
            StringBuilder sb = new StringBuilder();
            sb.append("id,mcc_code_tr_type,amount,\n");
            for (Data element:list) {
                sb.append(element.getId());
                sb.append(',');
                sb.append(element.getMccCodeTrType());
                sb.append(',');
                sb.append(element.getAmount());
                sb.append(",\n");
            }
            writer.write(sb.toString());
            writer.close();
            logger.debug("Файл успешно выгружен.");
        } catch (FileNotFoundException e) {
            logger.debug("При выгрузке файла произошла ошибка.");
        }
    }
}
