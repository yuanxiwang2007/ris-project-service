package com.rms.risproject.model.bo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "base_user")
@Data
public class BaseUserBo extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNo")
    private String phoneNo;
}
