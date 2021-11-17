package com.example.course_project_java.service;

import com.example.course_project_java.models.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class FileDownloadService {
    private static final String CSV_FILE = "src/main/resources/static/new_file.csv";

    public static void fileDownloadFromIterable(Iterable<Data> iterable){
        try (PrintWriter writer = new PrintWriter(new File(CSV_FILE))) {

            StringBuilder sb = new StringBuilder();
            sb.append("id,mcc_code_tr_type,amount,\n");
            for (Data element:iterable
                 ) {
                sb.append(element.getId());
                sb.append(',');
                sb.append(element.getMccCodeTrType());
                sb.append(',');
                sb.append(element.getAmount());
                sb.append(",\n");
            }
            writer.write(sb.toString());
            writer.close();
            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
