package com.key.tools.member.db.model;

import java.util.Date;

public class QQLogin {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qq_login.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qq_login.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qq_login.qq
     *
     * @mbggenerated
     */
    private Integer qq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qq_login.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qq_login.motify_time
     *
     * @mbggenerated
     */
    private Date motifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qq_login.id
     *
     * @return the value of qq_login.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qq_login.id
     *
     * @param id the value for qq_login.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qq_login.user_id
     *
     * @return the value of qq_login.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qq_login.user_id
     *
     * @param userId the value for qq_login.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qq_login.qq
     *
     * @return the value of qq_login.qq
     *
     * @mbggenerated
     */
    public Integer getQq() {
        return qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qq_login.qq
     *
     * @param qq the value for qq_login.qq
     *
     * @mbggenerated
     */
    public void setQq(Integer qq) {
        this.qq = qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qq_login.create_time
     *
     * @return the value of qq_login.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qq_login.create_time
     *
     * @param createTime the value for qq_login.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qq_login.motify_time
     *
     * @return the value of qq_login.motify_time
     *
     * @mbggenerated
     */
    public Date getMotifyTime() {
        return motifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qq_login.motify_time
     *
     * @param motifyTime the value for qq_login.motify_time
     *
     * @mbggenerated
     */
    public void setMotifyTime(Date motifyTime) {
        this.motifyTime = motifyTime;
    }
}