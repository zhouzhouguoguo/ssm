package com.zhl.o2o.entity;

import java.util.Date;

public class WechatAuth {
    private Long wechatAuthId;
    private String openId;
    private Date createTime;

    public Long getWechatAuthId() {
        return wechatAuthId;
    }

    public void setWechatAuthId(Long wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PersonInfo getPersonInfoj() {
        return personInfoj;
    }

    public void setPersonInfoj(PersonInfo personInfoj) {
        this.personInfoj = personInfoj;
    }

    private PersonInfo personInfoj;
}
