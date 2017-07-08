package me.songt.artsharing.service.impl;

import me.songt.artsharing.dao.PostCommentRepository;
import me.songt.artsharing.po.PostCommentEntity;
import me.songt.artsharing.service.PostCommentService;
import me.songt.artsharing.service.UserService;
import me.songt.artsharing.vo.PostCommentViewModel;
import me.songt.artsharing.vo.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2017/7/8.
 */
@Service
public class PostCommentServiceImpl implements PostCommentService
{
    @Autowired
    private PostCommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<PostCommentViewModel> getPostComments(int postId)
    {
        List<PostCommentEntity> postCommentEntities = commentRepository.findByPostId(postId);
        if (postCommentEntities == null)
        {
            return null;
        }
        List<PostCommentViewModel> commentViewModels = new ArrayList<>(postCommentEntities.size());
        postCommentEntities.forEach(postCommentEntity ->
        {
            PostCommentViewModel model = new PostCommentViewModel();
            model.setId(postCommentEntity.getId());
            model.setCommentContent(postCommentEntity.getCommentContent());
            model.setCommentAuthor(userService.getUserDetailInfo(postCommentEntity.getCommentAuthorId()));
            commentViewModels.add(model);
        });
        return commentViewModels;
    }

    @Override
    public PostCommentViewModel addPostComment(int postId, int authorId, String content)
    {
        UserViewModel userViewModel = userService.getUserDetailInfo(authorId);
        if (userViewModel == null)
        {
            return null;
        }
        PostCommentEntity commentEntity = new PostCommentEntity();
        PostCommentViewModel model = new PostCommentViewModel();
        commentEntity.setPostId(postId);
        commentEntity.setCommentAuthorId(authorId);
        commentEntity.setCommentContent(content);
        commentRepository.save(commentEntity);
        model.setId(commentEntity.getId());
        model.setCommentAuthor(userViewModel);
        model.setCommentContent(content);
        return model;
    }

    @Override
    public boolean deletePostComment(int postCommentId)
    {
        PostCommentEntity entity = commentRepository.findOne(postCommentId);
        if (entity == null)
        {
            return false;
        }
        commentRepository.delete(entity);
        return true;
    }

    @Override
    public PostCommentViewModel getPostComment(int postCommentId)
    {
        PostCommentEntity entity = commentRepository.findOne(postCommentId);
        PostCommentViewModel viewModel = new PostCommentViewModel();
        viewModel.setId(entity.getId());
        viewModel.setCommentContent(entity.getCommentContent());
        viewModel.setCommentAuthor(userService.getUserDetailInfo(entity.getCommentAuthorId()));
        return viewModel;
    }
}
