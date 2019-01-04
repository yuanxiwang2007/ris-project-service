package com.rms.risproject.model.bo;

import java.io.Serializable;

/**
 * @desc 
 * @author zhangqiufeng
 * @date 2018年12月21日
 */
public class MachineActvInfoVo implements Serializable{
    /**
     * 活动图名称
     */
    private String acImageName;
    /**
     * 活动图张数
     */
    private Integer imageAmount;
    /**
     * @return the acImageName
     */
    public String getAcImageName() {
        return acImageName;
    }
    /**
     * @param acImageName the acImageName to set
     */
    public void setAcImageName(String acImageName) {
        this.acImageName = acImageName;
    }
    /**
     * @return the imageAmount
     */
    public Integer getImageAmount() {
        return imageAmount;
    }
    /**
     * @param imageAmount the imageAmount to set
     */
    public void setImageAmount(Integer imageAmount) {
        this.imageAmount = imageAmount;
    }
    
}
