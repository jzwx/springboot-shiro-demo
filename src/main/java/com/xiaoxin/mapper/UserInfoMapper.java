package com.xiaoxin.mapper;

import com.xiaoxin.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Author:jzwx
 * @Desicription: UserInfoMapper
 * @Date:Created in 2018-11-09 15:53
 * @Modified By:
 */
@Component
public interface UserInfoMapper {
    //通过username查找用户信息
    UserInfo findByUsername(@Param("username") String username);
}
