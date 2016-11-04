package com.jx3.yanqijs.jx3equipment.model;

/**
 * Created by yanqijs on 2016/10/27.
 */

public class BaseEquipmentModel {
    public int pId = 0;//装备唯一id

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public double getQualityRank() {
        return qualityRank;
    }

    public void setQualityRank(double qualityRank) {
        this.qualityRank = qualityRank;
    }

    public double getEquipmentScore() {
        return equipmentScore;
    }

    public void setEquipmentScore(double equipmentScore) {
        this.equipmentScore = equipmentScore;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String equipmentName = null;//装备名称
    public String part = null;//装备部位
    public double qualityRank = 0;//品质等级
    public double equipmentScore = 0;//装备分数
    public String school = null;//职业
    public String stand = null;//突出的属性
    public String from = null;//产出途径


}
