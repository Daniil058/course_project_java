package com.example.course_project_java.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass
public class AbstractBaseData {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name="mcc_code_tr_type")
    protected String mccCodeTrType;

    @Column(name="amount")
    protected BigDecimal amount;
}
