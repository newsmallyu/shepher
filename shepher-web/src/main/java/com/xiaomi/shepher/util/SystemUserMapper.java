package com.xiaomi.shepher.util;


import com.xiaomi.shepher.model.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface SystemUserMapper {

    @Select("SELECT id, name, time, password FROM system_user WHERE name = #{name}")
    SystemUser getByName(@Param("name") String name);

    @Insert("INSERT INTO system_user(name, password ) VALUES (#{name}, #{password})")
    int addUser(SystemUser systemUser);

    @Select("SELECT * FROM system_user")
    List<SystemUser> listUser();

    @Delete("DELETE FROM system_user WHERE id = #{id}")
    int delUser(@Param("id") String id);

    @Update("UPDATE system_user SET password = #{password} WHERE id = #{id}")
    int updateUser(SystemUser systemUser);
}
