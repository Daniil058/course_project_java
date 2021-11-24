package com.example.course_project_java.service;

import com.example.course_project_java.entity.Data;
import com.example.course_project_java.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessingDataService {

    private final DataRepository dataRepository;

    private final FileDownloadService fileDownloadService;

    @Autowired
    public ProcessingDataService(
            DataRepository dataRepository,
            FileDownloadService fileDownloadService
    ){
        this.fileDownloadService = fileDownloadService;
        this.dataRepository = dataRepository;
    }

    public List<Data> getAndSaveDates(){
        List<Data> dates = this.getDates();
        saveDatesToFile(dates);
        return dates;
    }

    private List<Data> getDates(){
        return  dataRepository.getAllDispersion();
    }

    private void saveDatesToFile(List<Data> dates){
        fileDownloadService.fileDownloadFromIterable(dates);
    }
}
