package com.xiaomi.shepher.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author ay05
 * @create 3/21/2019
 */
public class UserFromSql implements UserDetailsService {
    @Autowired
    private SystemUserService systemUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SystemUser systemUser = systemUserService.queryByUserName(s);
        if (systemUser == null) {
            throw new UsernameNotFoundException("username is not exists");
        }
        return systemUser;
    }
}
