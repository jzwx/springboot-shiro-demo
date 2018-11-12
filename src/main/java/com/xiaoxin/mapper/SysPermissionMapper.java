package com.xiaoxin.mapper;

import com.xiaoxin.entity.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author:jzwx
 * @Desicription: SysPermissionMapper
 * @Date:Created in 2018-11-12 10:32
 * @Modified By:
 */
@Component
public interface SysPermissionMapper {
    //根据角色id查询角色对应的权限信息
    List<SysPermission> findPermissionByRoleId(@Param("roleId") Integer roleId);
}
