package com.gg.mappers;

import com.gg.entity.User;
import com.gg.entity.UserVO;

import java.util.List;

public interface UserMapper {

    /**
     * 用来查询获取所有的用户信息
     * @return User的集合
     */
    public List<User> findAll();

    /**
     * 通过id查询user
     * @param ID 表ID
     * @return 用户实体
     */
    public User findByID(int ID);

    /**
     * 用来新增一个用户
     * @param user 新增的实体
     * @return 受影响的行数
     */
    public int add(User user);

    /**
     * 用来根据ID修改数据
     * @param user 用来保存新数据的实体，内含ID
     * @return 更新的行数
     */
    public int updateByID(User user);

    /**
     * 通过ID删除数据
     *
     * @param ID 要删除的逐渐ID
     */
    public void deleteByID(int ID);

    /**
     * 通过用户名查询数据,模糊查询，传入参数的时候需要%
     * @param sName 用来模糊查询的用户名
     * @return  用户的实体集
     */
    public List<User> findByNameLike(String sName);

    /**
     * 通过用户名查询数据，模糊查询，传入参数的时候不需要%，sql中有设置%号
     * @param sName 用来模糊查询的用户名
     * @return 用户的实体集
     */
    public List<User> findByNameLike2(String sName);

    /**
     * 查询数据的条数
     * @return 数据的条数
     */
    public int findCount();

    /**
     * 通过UserVO查询user信息
     * @param userVO user的VO对象
     * @return user对象的List集合
     */
    public List<User> findByVO(UserVO userVO);

    /**
     * 通过配置ResultMap来查询数据
     * @return user的List集合
     */
    public List<User> findByResultMap();

    /**
     * 通过if标签来查找数据
     * @return user的List集合
     */
    public List<User> findByIf(User user);

    /**
     * 通过Foreach标签来查找数据
     * @return user的List集合
     */
    public List<User> findByForeach(User user);

    /**
     * 通过一对多的查询来获取信息
     * @return User的List集合
     */
    public List<User> findAllByOneToMore();

    /**
     * 查询用户对应的职责
     * @return 用户的list集合
     */
    public List<User> findAllRole();

    /**
     * 通过延迟加载查询数据
     * @return user的list集合
     */
    public List<User> findAllLazy();
}
