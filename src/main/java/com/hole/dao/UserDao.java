package com.hole.dao;

import com.hole.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author wangcj
 * @date 2018/4/27 14:51
 * @desc
 * @since 1.0
 */
public interface UserDao extends JpaRepository<User,Integer> {

}
