import com.jjl.Dao.BlogMapper;
import com.jjl.pojo.Blog;
import com.jjl.utils.IDUtils;
import com.jjl.utils.mybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class mytest {
    @Test
    public  void test(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getid());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);
        blog.setId(IDUtils.getid());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getid());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getid());
        blog.setTitle("微服务");
        mapper.addBlog(blog);
        sqlSession.close();
    }
    //查询博客用if
    @Test
    public  void queryBlogIF(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map=new HashMap();
      //  map.put("title","Java");
        map.put("author","狂神说");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog b:blogs
             ) {
            System.out.println(b);
        }
        sqlSession.close();
    }
    @Test
    public  void choose(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map=new HashMap();
        map.put("views",9999);
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog b:blogs
             ) {
            System.out.println(b);
        }
        sqlSession.close();
    }
    //更新操作
    @Test
    public  void update(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map=new HashMap();
        map.put("id","fb700310cac44abeae3c23647b0e1e18");
        map.put("title","ljj");
        map.put("author","贾久乐");
        int update = mapper.update(map);
        System.out.println(update);
        sqlSession.close();

    }
}
