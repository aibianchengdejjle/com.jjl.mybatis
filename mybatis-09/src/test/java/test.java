import com.jjl.Dao.UserMapper;
import com.jjl.pojo.User;
import com.jjl.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test {
    @Test
    public  void test(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        SqlSession sqlSession1 = mybatisUtils.getSqlSession();
        SqlSession sqlSession2 = mybatisUtils.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getUser(1);
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        sqlSession.close();
        List<User> user1 = mapper1.getUser(1);
        System.out.println(user1==user);
        sqlSession1.close();
        List<User> user2 = mapper2.getUser(1);
        sqlSession2.close();
    }
}
