package me.songt.artsharing.dao;

import me.songt.artsharing.po.PostCommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tony on 2017/7/5.
 */
@Repository
public interface PostCommentRepository extends CrudRepository<PostCommentEntity, Integer>
{
    List<PostCommentEntity> findByPostId(int postId);
}
