package com.example.course_project_java.repository;

import com.example.course_project_java.models.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
    @Query(value="select ROW_NUMBER() over (order by mcc_code_tr_type) as id, " +
            "mcc_code_tr_type,   sqrt(avg(power(amount,2))-POWER(AVG(amount),2))as amount " +
            "from data " +
            "Where amount > 0 " +
            "GROUP BY mcc_code_tr_type " +
            "HAVING count(mcc_code_tr_type) >= 10", nativeQuery = true)
    List<Data> getAllDespersion();
}
