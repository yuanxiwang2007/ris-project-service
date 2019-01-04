package com.rms.risproject.model.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 
 * @author zhangqiufeng
 * @date 2018年12月21日
 */
public class MachineScanRecordInfoVo implements Serializable{
    
    private String machineID;
    private String openID;
    private String unionID;
    private Integer sexType;
    private String phone;
    private Date addTime;
    private Integer isDelete;
    private MachineInfoVo machineInfoVo;
    private MachineActvInfoVo actvInfoVo;
    /**
     * @return the machineID
     */
    public String getMachineID() {
        return machineID;
    }
    /**
     * @param machineID the machineID to set
     */
    public void setMachineID(String machineID) {
        this.machineID = machineID;
    }
    /**
     * @return the openID
     */
    public String getOpenID() {
        return openID;
    }
    /**
     * @param openID the openID to set
     */
    public void setOpenID(String openID) {
        this.openID = openID;
    }
    /**
     * @return the unionID
     */
    public String getUnionID() {
        return unionID;
    }
    /**
     * @param unionID the unionID to set
     */
    public void setUnionID(String unionID) {
        this.unionID = unionID;
    }
    /**
     * @return the sexType
     */
    public Integer getSexType() {
        return sexType;
    }
    /**
     * @param sexType the sexType to set
     */
    public void setSexType(Integer sexType) {
        this.sexType = sexType;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @return the addTime
     */
    public Date getAddTime() {
        return addTime;
    }
    /**
     * @param addTime the addTime to set
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
    /**
     * @return the isDelete
     */
    public Integer getIsDelete() {
        return isDelete;
    }
    /**
     * @param isDelete the isDelete to set
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    /**
     * @return the machineInfoVo
     */
    public MachineInfoVo getMachineInfoVo() {
        return machineInfoVo;
    }
    /**
     * @param machineInfoVo the machineInfoVo to set
     */
    public void setMachineInfoVo(MachineInfoVo machineInfoVo) {
        this.machineInfoVo = machineInfoVo;
    }


    /**
     * @return the actvInfoVo
     */
    public MachineActvInfoVo getActvInfoVo() {
        return actvInfoVo;
    }
    /**
     * @param actvInfoVo the actvInfoVo to set
     */
    public void setActvInfoVo(MachineActvInfoVo actvInfoVo) {
        this.actvInfoVo = actvInfoVo;
    }

    
}
