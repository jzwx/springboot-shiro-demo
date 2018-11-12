package com.xiaoxin.service.impl;

import com.xiaoxin.entity.UserInfo;
import com.xiaoxin.mapper.UserInfoMapper;
import com.xiaoxin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:jzwx
 * @Desicription: UserInfoServiceImpl
 * @Date:Created in 2018-11-09 15:17
 * @Modified By:
 */
@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoMapper.findByUsername(username);
    }
}
