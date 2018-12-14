package com.rms.risproject.model.response;

import lombok.Data;

import java.util.List;

@Data
public class TestVo {

    private String name;

    private String nameEn;

    private List<String> projects;

    private List<String> projectsEn;

    private List<Character> list;
}
