package me.songt.artsharing.service.impl;

import me.songt.artsharing.dao.PostLikesRepository;
import me.songt.artsharing.po.PostLikesEntity;
import me.songt.artsharing.service.PostLikeService;
import me.songt.artsharing.service.UserService;
import me.songt.artsharing.vo.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2017/7/8.
 */
@Service
public class PostLikeServiceImpl implements PostLikeService
{
    @Autowired
    private PostLikesRepository repository;

    @Autowired
    private UserService userService;

    @Override
    public List<UserViewModel> getPostLikes(int postId)
    {
        List<PostLikesEntity> postLikesEntities = repository.findByPostId(postId);
        if (postLikesEntities == null)
        {
            return null;
        }
        List<UserViewModel> likeUsers = new ArrayList<>(postLikesEntities.size());
        postLikesEntities.forEach(postLikesEntity ->
        {
            UserViewModel model = userService.getUserDetailInfo(postLikesEntity.getPostLikeUserid());
            likeUsers.add(model);
        });
        return likeUsers;
    }

    @Override
    public void like(int postId, int userId)
    {
        PostLikesEntity entity = new PostLikesEntity();
        entity.setPostId(postId);
        entity.setPostLikeUserid(userId);
        repository.save(entity);
    }

    @Override
    public void dislike(int postId, int userId)
    {
        PostLikesEntity entity = repository.findByPostIdAndPostLikeUserid(postId, userId);
        if (entity == null)
        {
            return;
        }
        repository.delete(entity);
    }
}
