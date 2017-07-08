package me.songt.artsharing.service;

import me.songt.artsharing.vo.UserViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 2017/7/8.
 */
@Service
public interface PostLikeService
{
    List<UserViewModel> getPostLikes(int postId);

    void like(int postId, int userId);

    void dislike(int postId, int userId);

}
