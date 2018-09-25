package com.rms.risproject.model.response;

import com.rms.common.excel.Excel;
import lombok.Data;

@Data
public class BaseUserResp {

    @Excel(ColumnNum = 0,ColumnTitle = "主键",ColumnWidth = 200)
    private String keyId;

    @Excel(ColumnNum = 1,ColumnTitle = "编码",ColumnWidth = 100)
    private String code;

    @Excel(ColumnNum = 2,ColumnTitle = "名称",ColumnWidth = 200)
    private String name;

    @Excel(ColumnNum = 3,ColumnTitle = "电话",ColumnWidth = 200)
    private String phoneNo;

    @Excel(ColumnNum = 4,ColumnTitle = "年龄",ColumnWidth = 100)
    private Integer age;
}
