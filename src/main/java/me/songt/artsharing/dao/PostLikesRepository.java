package me.songt.artsharing.dao;

import me.songt.artsharing.po.PostLikesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tony on 2017/7/5.
 */
@Repository
public interface PostLikesRepository extends CrudRepository<PostLikesEntity, Integer>
{
    PostLikesEntity findByPostIdAndPostLikeUserid(int postId, int postLikeUserId);

    List<PostLikesEntity> findByPostId(int postId);
}
