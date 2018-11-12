package com.xiaoxin.service;

import com.xiaoxin.entity.UserInfo;

/**
 * @Author:jzwx
 * @Desicription: UserInfoService
 * @Date:Created in 2018-11-09 15:16
 * @Modified By:
 */
public interface UserInfoService {
    /**通过username查找用户信息;*/
    UserInfo findByUsername(String username);
}
