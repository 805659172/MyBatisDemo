package com.gg.mappers;

import com.gg.entity.Note;

import java.util.List;

public interface NoteMapper {

    /**
     * 查询所有的笔记
     * @return 笔记的list集合
     */
    public List<Note> findAll();

    /**
     * 查询笔记，延迟加载
     * @return 笔记的list集合
     */
    public List<Note> findAllLazy();

    /**
     * 通过用户查询笔记信息
     * @return 笔记的list集合
     */
    public List<Note> findByInputUserID(Integer userID);

}
