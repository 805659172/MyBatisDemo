package com.gg.test;

import com.gg.entity.Note;
import com.gg.mappers.NoteMapper;
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

public class NoteDemo {
    private InputStream inputStream = null;
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;
    private NoteMapper noteMapper = null;

    @Before
    public void init() throws IOException {
        /*加载主配置文件*/
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        /*创建SqlSessionFactory*/
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /*得到SqlSession*/
        sqlSession = sqlSessionFactory.openSession();
        /*得到noteMapper的代理对象*/
        noteMapper = sqlSession.getMapper(NoteMapper.class);
    }

    @After
    public void destroy() throws IOException {
        inputStream.close();
        sqlSession.close();
    }

    /**
     * 多对一查询测试
     */
    @Test
    public void findAllTest(){
        List<Note> noteList = noteMapper.findAll();
        for (Note note : noteList) {
            System.out.println(note);
        }
    }

    /**
     * 多对一查询延迟加载测试
     */
    @Test
    public void findAllLazyTest(){
        List<Note> noteList = noteMapper.findAllLazy();
        for (Note note : noteList) {
            System.out.println(note.getLtText());
        }
    }

    /**
     * 通过参数进行数据查询
     */
    @Test
    public void findByInputUserID(){
        List<Note> noteList = noteMapper.findByInputUserID()
    }



}
