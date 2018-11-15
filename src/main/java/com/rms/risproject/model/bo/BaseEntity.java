package com.rms.risproject.model.bo;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;


@Data
public class BaseEntity {

    @Id
    @Column(name = "keyId")
    //@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select REPLACE(uuid(),'-','')")
    private String keyId;

    @Column(name = "IsDelete")
    private Integer isDelete=0;

    @Column(name = "gmt_create")
    private String gmtCreate;

    @Column(name = "gmt_modify")
    private String gmtModify;

    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;
}
