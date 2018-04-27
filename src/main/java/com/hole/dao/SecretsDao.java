package com.hole.dao;

import com.hole.entity.Secrets;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author wangcj
 * @date 2018/4/27 14:53
 * @desc
 * @since 1.0
 */
public interface SecretsDao extends JpaRepository<Secrets,Integer> {

}
