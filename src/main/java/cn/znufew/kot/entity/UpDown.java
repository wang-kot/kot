package cn.znufew.kot.entity;

import java.util.Date;

public class UpDown {
    private Integer id;

    private Boolean toType;

    private Long from;

    private Long to;

    private Byte upOwn;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getToType() {
        return toType;
    }

    public void setToType(Boolean toType) {
        this.toType = toType;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public Byte getUpOwn() {
        return upOwn;
    }

    public void setUpOwn(Byte upOwn) {
        this.upOwn = upOwn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}