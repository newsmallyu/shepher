package com.xiaomi.shepher.util;

import com.xiaomi.shepher.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author ay05
 * @create 3/21/2019
 */
@Component
public class SystemUserService {
    @Autowired
    SystemUserMapper systemUserMapper;

    @Transactional
    public SystemUser queryByUserName(String name){
        return systemUserMapper.getByName(name);
    }

    @Transactional
    public void addUser(SystemUser systemUser){
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        String password = md5PasswordEncoder.encodePassword(systemUser.getPassword(), new String());
        systemUser.setPassword(password);
        systemUserMapper.addUser(systemUser);
    }

    @Transactional
    public List<SystemUser> listUser(){
        List<SystemUser> userlist = systemUserMapper.listUser();
        return userlist;
    }

    @Transactional
    public void delUser(String id){
        systemUserMapper.delUser(id);
    }
    @Transactional
    public void updateUser(SystemUser systemUser) {
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        String password = md5PasswordEncoder.encodePassword(systemUser.getPassword(), new String());
        systemUser.setPassword(password);
        systemUserMapper.updateUser(systemUser);
    }
}
