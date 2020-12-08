package com.gg.test;

import com.gg.entity.User;
import com.gg.entity.UserDetail;
import com.gg.entity.UserVO;
import com.gg.mappers.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDemo {
    private InputStream resourceAsStream = null;
    private SqlSessionFactory factory = null;
    private SqlSession sqlSession = null;
    private UserMapper userMapper = null;

    @Before
    public void init() throws IOException {
        // 加载主配置文件
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 通过工厂对象获取到SqlSession对象,没有设置事务的方式，默认手动提交
        sqlSession = factory.openSession();
        // 表示开启了事务的自动提交
        // sqlSession = factory.openSession(true);
        // 获取到代理对象，MyBatis框架生成的代理对象
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void destroy() throws IOException {
        // 关闭资源
        sqlSession.close();
        resourceAsStream.close();
    }



    /**
     * 测试查询用户的方法
     * 根据命名空间和sql的Id来执行sql语句
     */
    @Test
    public void getUserByNameSpaceAndID() throws IOException {
        // 调用SqlSession对象中的方法    命名空间加sql的ID
        List<User> userList = sqlSession.selectList("com.gg.mappers.UserMapper.findAll");
        // 遍历集合
        for(User user : userList){
            System.out.println(user.toString());
        }
    }

    /**
     * 测试使用代理对象查询用户的方法
     */
    @Test
    public void getUserByProxy() throws IOException {
        // mapper执行的就是代理对象
        List<User> userList = userMapper.findAll();

        // 遍历集合
        for(User user : userList){
            System.out.println(user.toString());
        }
    }

    /**
     * 测试通过id查询数据
     */
    @Test
    public void findByIDTest(){
        User user = userMapper.findByID(1);
        System.out.println(user.toString());
    }

    /**
     * 用来测试新增方法
     */
    @Test
    public void addTest(){
        /*用来进行新增的实体*/
        User user = new User();
        user.setsAccountNO("805659172@qq.com");
        user.setsPassword("ouweiyu");
        user.setsName("天使の羽");
        user.setnStatusID(1);

        // 执行新增数据的方法
        int result = userMapper.add(user);

        // 如果自动提交事务设置为false，则需要手动提交事务
        // 提交事务
        sqlSession.commit();

        System.out.println("新增的条数：" + result);
    }

    /**
     * 通过ID更新数据库
     */
    @Test
    public void updateByIDTest(){
        /*用来更新的实体*/
        User user = new User();
        user.setsAccountNO("3386831655@qq.com");
        user.setsPassword("ouweiyu");
        user.setsName("羽");
        user.setID(2);

        /*执行更新操作*/
        int result = userMapper.updateByID(user);

        /*提交事务*/
        sqlSession.commit();
        System.out.println("更新的数据个数为：" + result);
    }

    /**
     * 通过ID删除数据测试
     */
    @Test
    public void deleteByIDTest(){
        /*执行删除操作*/
        userMapper.deleteByID(1);
        /*提交事务*/
        sqlSession.commit();
    }

    /**
     * 通过用户名模糊查询测试,穿参的时候带上%
     */
    @Test
    public void findByNameLike(){
        /* 开始查询数据 */
        List<User> userList = userMapper.findByNameLike("%羽%");
        /* 遍历数据 */
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    /**
     * 通过用户名模糊查询测试,穿参的时候不需要带%，sql中有设置%号
     */
    @Test
    public void findByNameLike2(){
        /* 开始查询数据 */
        List<User> userList = userMapper.findByNameLike2("羽");
        /* 遍历数据 */
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    /**
     * 测试通过count函数查询用户的数量
     */
    @Test
    public void findCountTest(){
        /*开始查询数据*/
        int count = userMapper.findCount();
        System.out.println("用户数量：" + count);
    }

    /**
     * 测试通过VO查询数据
     */
    @Test
    public void findByVO(){
        /*开始封装查询参数对象*/
        UserVO userVO = new UserVO();
        User user = new User();
        user.setsAccountNO("805659172@qq.com");
        UserDetail userDetail = new UserDetail();
        userDetail.setAddress("羽");

        /*向UserVO中写入数据*/
        userVO.setUser(user);
        userVO.setUserDetail(userDetail);

        /*开始查询数据*/
        List<User> userList = userMapper.findByVO(userVO);
        for (User userTemp : userList) {
            System.out.println(userTemp);
        }
    }

    /**
     * 通过配置resultMap来查询数据
     */
    @Test
    public void findByResultMap(){
        List<User> userList = userMapper.findByResultMap();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 通过if拼接sql测试
     */
    @Test
    public void findByIfTest(){
        User user = new User();
        //user.setsAccountNO("805659172@qq.com");
        user.setsName("%羽%");
        List<User> userList = userMapper.findByIf(user);
        for (User userTemp : userList) {
            System.out.println(userTemp);
        }
    }

    /**
     * 测试Foreach标签
     */
    @Test
    public void findByForeach(){
        User user = new User();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        user.setIDs(ids);
        List<User> userList = userMapper.findByForeach(user);
        for (User userTemp : userList) {
            System.out.println(userTemp);
        }
    }

    /**
     * 用户，笔记一对多关联查询测试
     */
    @Test
    public void findAllByOneToMoreTest(){
        List<User> userList = userMapper.findAllByOneToMore();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 查找所有用户对应的职责
     */
    @Test
    public void findAllRoleTest(){
        List<User> userList = userMapper.findAllRole();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 一对多延迟加载测试
     */
    @Test
    public void findAllLazyTest() {
        List<User> userList = userMapper.findAllLazy();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
