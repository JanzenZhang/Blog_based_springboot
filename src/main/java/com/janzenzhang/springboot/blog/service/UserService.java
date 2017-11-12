package com.janzenzhang.springboot.blog.service;


import com.janzenzhang.springboot.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
用户服务接口
 */
public interface UserService {

    /**
     * 保存用户
     *
     * @return
     */
    User saveOrUpdateUser(User user);


    User registerUser(User user);

    /**
     * 删除用户
     *
     * @return
     */
    void removeUser(Long id);


    User getUserById(Long id);


    /**
     * 根据用户名进行分页模糊查询
     *
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);
}
