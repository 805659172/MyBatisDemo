package com.gg.test;

import com.gg.entity.Role;
import com.gg.mappers.RoleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RoleDemo {
    private InputStream resourceAsStream = null;
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;
    private RoleMapper roleMapper = null;

    @Before
    public void init() throws IOException {
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
        roleMapper = sqlSession.getMapper(RoleMapper.class);
    }

    @After
    public void destroy() throws IOException {
        resourceAsStream.close();
        sqlSession.close();
    }

    @Test
    public void findAllTest(){
        List<Role> roleList = roleMapper.findAll();
        for (Role role : roleList) {
            System.out.println(role);
        }
    }


}
