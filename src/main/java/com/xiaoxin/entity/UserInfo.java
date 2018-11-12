package com.xiaoxin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:jzwx
 * @Desicription: UserInfo
 * @Date:Created in 2018-11-09 15:20
 * @Modified By:
 */
@Data
@AllArgsConstructor //拥有所有变量构造函数
@NoArgsConstructor //没有变量的构造函数
public class UserInfo {
    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 账号
     */
    private String username;

    /**
     * 别名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 状态
     */
    private byte state;

    /**
     * 密码盐
     *
     * @return
     */
    public String getCredentialsSalt() {
        return this.username + this.salt;
    }

}
