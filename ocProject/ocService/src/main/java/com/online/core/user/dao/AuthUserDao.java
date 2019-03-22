package com.online.core.user.dao;

        import com.online.core.user.domain.AuthUser;

public interface AuthUserDao {
    /**
     * 根据usernmae获取
     * @param username
     * @return
     */
    AuthUser getByUsername(String username);

    /**
     *
     * @param authUser
     */
    void createSelectivity(AuthUser authUser);
}
