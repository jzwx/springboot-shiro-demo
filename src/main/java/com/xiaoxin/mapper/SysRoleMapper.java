package com.xiaoxin.mapper;

import com.xiaoxin.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author:jzwx
 * @Desicription: SysRoleMapper
 * @Date:Created in 2018-11-12 10:22
 * @Modified By:
 */
@Component
public interface SysRoleMapper {
    //通过username查找用户角色信息
    List<SysRole> findRoleByUsername(@Param("username")String username);
}
