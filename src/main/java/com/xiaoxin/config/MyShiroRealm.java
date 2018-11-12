package com.xiaoxin.config;

import com.xiaoxin.entity.UserInfo;
import com.xiaoxin.mapper.SysPermissionMapper;
import com.xiaoxin.mapper.SysRoleMapper;
import com.xiaoxin.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:jzwx
 * @Desicription: MyShiroRealm
 * @Date:Created in 2018-11-09 16:59
 * @Modified By:
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    /**
     * 获取授权信息
     *
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principal.getPrimaryPrincipal();
        sysRoleMapper.findRoleByUsername(userInfo.getUsername()).stream().forEach(sysRole -> {
            authorizationInfo.addRole(sysRole.getRole());
            sysPermissionMapper.findPermissionByRoleId(sysRole.getId()).stream().forEach(
                    sysPermission -> {
                        authorizationInfo.addStringPermission(sysPermission.getPermission());
                    }
            );
        });
        return authorizationInfo;
    }

    /**
     * 获取认证信息
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号
        String username = (String) token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找User对象,如果找到，没找到.
        //实际项目中,这里可以根据实际情况做缓存，如果不做，shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("---->>userInfo=" + userInfo);
        if (userInfo == null) {
            //没有返回登录用户名对应的SimpleAuthenticationInfo对象时，就会在LoginController中抛出UnknownAccountException异常
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo,//用户名
                userInfo.getPassword(),//密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName() //realm name
        );
        return authenticationInfo;
    }
}
