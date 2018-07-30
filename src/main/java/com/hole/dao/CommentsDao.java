package com.hole.dao;

import com.hole.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author wangcj
 * @date 2018/4/27 14:54
 * @desc
 * @since 1.0
 */
public interface CommentsDao extends JpaRepository<Comments,Integer> {

    List<Comments> findBySecretIdAndIsDelOrderByCreateTimeAsc(Integer secretId,Integer isDel);

}
