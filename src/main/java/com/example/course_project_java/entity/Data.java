package com.example.course_project_java.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Data extends AbstractBaseData{

    public Data(String mccCode,String trType, BigDecimal amount){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mccCode);
        stringBuilder.append(' ');
        stringBuilder.append(trType);
        this.mccCodeTrType = stringBuilder.toString();
        this.amount = amount;
    }

    public Data() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMccCodeTrType() {
        return mccCodeTrType;
    }

    public void setMccCodeTrType(String mccCodeTrType) {
        this.mccCodeTrType = mccCodeTrType;
    }
}
