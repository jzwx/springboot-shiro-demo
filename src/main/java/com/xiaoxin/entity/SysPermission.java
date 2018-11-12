package com.xiaoxin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:jzwx
 * @Desicription: SysPermission
 * @Date:Created in 2018-11-09 15:38
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限字符串
     */
    private String permission;
}
