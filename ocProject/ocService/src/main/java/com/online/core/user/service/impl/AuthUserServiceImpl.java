package com.online.core.user.service.impl;

import com.online.core.user.dao.AuthUserDao;
import com.online.core.user.domain.AuthUser;
import com.online.core.user.service.IAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthUserServiceImpl implements IAuthUserService {

    @Autowired
    private AuthUserDao authUserDao;

    /**
     * 根据username获取
     */
    public AuthUser getByUsername(String username){
//        System.out.println("2222");
//        System.out.println(authUserDao);
        return authUserDao.getByUsername(username);
    }

    /**
     * 保存用户
     * @param authUser
     */
    public void createSelectivity(AuthUser authUser) {
        authUserDao.createSelectivity(authUser);
    }
}
