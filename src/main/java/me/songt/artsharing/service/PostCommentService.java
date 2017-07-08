package me.songt.artsharing.service;

import me.songt.artsharing.vo.PostCommentViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 2017/7/8.
 */
@Service
public interface PostCommentService
{
    List<PostCommentViewModel> getPostComments(int postId);

    PostCommentViewModel addPostComment(int postId, int authorId, String content);

    boolean deletePostComment(int postCommentId);

    PostCommentViewModel getPostComment(int postCommentId);
}
