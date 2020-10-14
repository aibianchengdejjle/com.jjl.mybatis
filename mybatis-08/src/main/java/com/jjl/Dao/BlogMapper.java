package com.jjl.Dao;

import com.jjl.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    int addBlog(Blog blog);
    //查询博客 if
    List<Blog> queryBlogIF(Map map);
    //查询博客 choose
    List<Blog> queryBlogChoose(Map map);
    //更新博客
    int update(Map map);

}
