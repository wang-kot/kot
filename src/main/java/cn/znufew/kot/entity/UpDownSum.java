package cn.znufew.kot.entity;

import java.util.Date;

public class UpDownSum {
    private Integer id;

    private Boolean type;

    private Long objId;

    private Long sumUp;

    private Long sumDown;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Long getObjId() {
        return objId;
    }

    public void setObjId(Long objId) {
        this.objId = objId;
    }

    public Long getSumUp() {
        return sumUp;
    }

    public void setSumUp(Long sumUp) {
        this.sumUp = sumUp;
    }

    public Long getSumDown() {
        return sumDown;
    }

    public void setSumDown(Long sumDown) {
        this.sumDown = sumDown;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}