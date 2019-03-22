package com.online.core.user.service;

import com.online.core.user.domain.AuthUser;

public interface IAuthUserService {
    AuthUser getByUsername(String username);

    void createSelectivity(AuthUser authUser);
}
