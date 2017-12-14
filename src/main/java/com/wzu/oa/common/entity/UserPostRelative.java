package com.wzu.oa.common.entity;

import javax.persistence.*;

@Table(name = "user_post_relative")
public class UserPostRelative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "userId")
    private Integer userid;

    /**
     * 岗位id
     */
    @Column(name = "postId")
    private Integer postid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return userId - 用户id
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     *
     * @param userid 用户id
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取岗位id
     *
     * @return postId - 岗位id
     */
    public Integer getPostid() {
        return postid;
    }

    /**
     * 设置岗位id
     *
     * @param postid 岗位id
     */
    public void setPostid(Integer postid) {
        this.postid = postid;
    }
}