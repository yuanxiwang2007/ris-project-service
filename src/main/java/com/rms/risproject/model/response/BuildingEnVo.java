package com.rms.risproject.model.response;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class BuildingEnVo {

    private static final long serialVersionUID = 1L;

    private String keyID;
    /**
     * 楼层图片
     */
    private String img;

    /**
     * 楼层图片
     */
    private String imgEn;
    private Boolean tf;
    private List<Boolean> tfList;
    private Map<String,BuildingEnVo> enVoMap;
    private Set<BuildingEnVo> buildingEnVoSet;
    private List<String> recordList;
    private List<String> recordListEn;

    public List<TestVo> getTestVos() {
        return testVos;
    }

    public void setTestVos(List<TestVo> testVos) {
        this.testVos = testVos;
    }

    private List<TestVo> testVos;

    public List<String> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<String> recordList) {
        this.recordList = recordList;
    }

    public List<String> getRecordListEn() {
        return recordListEn;
    }

    public void setRecordListEn(List<String> recordListEn) {
        this.recordListEn = recordListEn;
    }

    public Map<String, BuildingEnVo> getEnVoMap() {
        return enVoMap;
    }

    public void setEnVoMap(Map<String, BuildingEnVo> enVoMap) {
        this.enVoMap = enVoMap;
    }

    public Set<BuildingEnVo> getBuildingEnVoSet() {
        return buildingEnVoSet;
    }

    public void setBuildingEnVoSet(Set<BuildingEnVo> buildingEnVoSet) {
        this.buildingEnVoSet = buildingEnVoSet;
    }

    public List<Boolean> getTfList() {
        return tfList;
    }

    public void setTfList(List<Boolean> tfList) {
        this.tfList = tfList;
    }

    public Boolean getTf() {
        return tf;
    }

    public void setTf(Boolean tf) {
        this.tf = tf;
    }

    public String getKeyID() {
        return keyID;
    }

    public void setKeyID(String keyID) {
        this.keyID = keyID;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgEn() {
        return imgEn;
    }

    public void setImgEn(String imgEn) {
        this.imgEn = imgEn;
    }
}