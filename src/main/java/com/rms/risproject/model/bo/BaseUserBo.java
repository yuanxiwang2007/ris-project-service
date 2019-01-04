package com.rms.risproject.model.bo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "base_userinfo")
@Data
public class BaseUserBo extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNo")
    private String phoneNo;

    @Column(name = "loginName")
    private String loginName;

    @Column(name = "loginPwd")
    private String loginPwd;

    public static Integer num1 = 100;
    public static final Integer num2 = 100;
}
