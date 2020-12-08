package com.gg.mappers;

import com.gg.entity.Role;

import java.util.List;

public interface RoleMapper {

    /**
     * 查询所有指责信息
     * @return 职责的list集合
     */
    public List<Role> findAll();
}
