package com.xiaoxin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:jzwx
 * @Desicription: SysRole
 * @Date:Created in 2018-11-09 15:33
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {
    /**
     * 角色id
     */
    private Integer id;

    /**
     * 角色标识程序中判断使用,如"admin",这个是唯一的:
     */
    private String role;

    /**
     * 角色描述,UI界面显示使用
     */
    private String description;

    /**
     * 是否可用,如果不可用将不会添加给用户
     */
    private Boolean available = Boolean.FALSE;
}
