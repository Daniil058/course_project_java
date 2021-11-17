package com.example.course_project_java.models;

import javax.persistence.*;

@Entity
public class Data {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="mcc_code_tr_type")
    private String mccCodeTrType;
    @Column(name="amount")
    private Double amount;


    public Data(String mccCode,String trType, Double amount){
        this.mccCodeTrType = mccCode+" "+trType;
        this.amount = amount;
    }

    public Data() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMccCodeTrType() {
        return mccCodeTrType;
    }

    public void setMccCodeTrType(String mccCodeTrType) {
        this.mccCodeTrType = mccCodeTrType;
    }
}
