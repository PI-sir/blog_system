package com.halou.mapper;

import com.halou.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Insert("INSERT INTO users (username, password) VALUES (#{username}, #{password})")
    void userregister(User user);


    @Select("select * from users where username= #{username}")
    User userlogin(User user);

    @Delete("delete from users where id=#{id}")
    int userdelete(int id);

    @Update({
            "<script>",
            "update users",
            "<set>",
            "<if test='username != null'>username = #{username},</if>",
            "<if test='password != null'>password = #{password},</if>",
            "<if test='gender != null'>gender = #{gender},</if>",
            "<if test='createtime != null'>createtime = #{createtime},</if>",
            "<if test='qq != null'>qq = #{qq},</if>",
            "<if test='age != null'>age = #{age},</if>",
            "<if test='address != null'>address = #{address}</if>",
            "</set>",
            "where id = #{id}",
            "</script>"
    })
    int userupdate(User user);


    @Select("select * from users where id=#{id}")
    User usershow(int id);


    @Select("select * from users")
    List<User> userlist();
}
