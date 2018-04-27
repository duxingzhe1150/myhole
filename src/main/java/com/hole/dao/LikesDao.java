package com.hole.dao;

import com.hole.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author wangcj
 * @date 2018/4/27 14:53
 * @desc
 * @since 1.0
 */
public interface LikesDao extends JpaRepository<Likes,Integer> {

}
