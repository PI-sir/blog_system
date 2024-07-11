package com.halou.mapper;


import com.halou.pojo.Blog;
import com.halou.pojo.Categories;
import com.halou.pojo.Favourite;
import com.halou.pojo.Tag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BlogMapper {

    @Insert("INSERT INTO blogs (author, title, text, createtime, state, like_count, collect_count) " +
            "VALUES (#{author}, #{title}, #{text}, #{createtime}, #{state}, #{like}, #{collect})")
    int save(Blog blog);


    @Update({
            "<script>",
            "UPDATE blogs",
            "<set>",
            "<if test='author != null'>author = #{author},</if>",
            "<if test='title != null'>title = #{title},</if>",
            "<if test='text != null'>text = #{text},</if>",
            "<if test='createtime != null'>createtime = #{createtime},</if>",
            "<if test='state != null'>state = #{state},</if>",
            "<if test='like != null'> like_count = #{like},</if>",
            "<if test='collect != null'> collect_count = #{collect},</if>",
            "<if test='kindid != null'>kindid = #{kindid}</if>",
            "</set>",
            "WHERE id = #{id}",
            "</script>"
    })
    int update(Blog blog);

    @Select("SELECT * FROM blogs WHERE id = #{id}")
    Blog show(int id);

    @Delete("DELETE FROM blogs WHERE id = #{id}")
    int delete(int id);

    @Insert("INSERT INTO favorites (id, blogid, userid) VALUES (#{id}, #{blogid}, #{userid})")
    int collect(Favourite favourite);


    @Insert("INSERT INTO tags (title, blogid) VALUES (#{title}, #{blogid})")
    int tag(Tag tag);

    @Insert("insert into categories(kindname, userid)values (#{kindname},#{userid})")
    int newkind(Categories categories);

    @Select("select * from blogs")
    List<Blog> list2();

    @Select("select * from blogs where title=#{name}")
    List<Blog> list(String name);
}