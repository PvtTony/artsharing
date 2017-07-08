package me.songt.artsharing.service.impl;

import me.songt.artsharing.dao.PostRepository;
import me.songt.artsharing.po.PostEntity;
import me.songt.artsharing.service.*;
import me.songt.artsharing.utils.IntegerSpliter;
import me.songt.artsharing.vo.ArtViewModel;
import me.songt.artsharing.vo.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2017/7/8.
 */
@Service
public class PostServiceImpl implements PostService
{
    @Autowired
    private UserService userService;

    @Autowired
    private PostLikeService postLikeService;

    @Autowired
    private PostCommentService postCommentService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ArtService artService;

    @Override
    public List<PostViewModel> getAllPosts(String sortField, int pageIndex, int pageSize, boolean desc)
    {
        Page<PostEntity> postEntities = postRepository.findAll(new PageRequest(pageIndex, pageSize,
                new Sort(desc ? Sort.Direction.DESC : Sort.Direction.ASC, sortField)));
        List<PostViewModel> postViewModelList = convertPostEntitiesToPostViewModels(postEntities);
        return postViewModelList;
    }

    @Override
    public List<PostViewModel> getUserPosts(int authorId, String sortField, int pageIndex, int pageSize, boolean desc)
    {
        Page<PostEntity> postEntities = postRepository.findByPostAuthor(authorId, new PageRequest(pageIndex, pageSize,
                new Sort(desc ? Sort.Direction.DESC : Sort.Direction.ASC, sortField)));
        if (postEntities == null)
        {
            return null;
        }
        return convertPostEntitiesToPostViewModels(postEntities);
    }

    @Override
    public PostViewModel addPost(int authorId, String postContent, List<Integer> postArtId)
    {
        PostEntity postEntity = new PostEntity();
        postEntity.setPostAuthor(authorId);
        postEntity.setPostContent(postContent);
        postEntity.setPostArts(IntegerSpliter.IntArrayToStr(postArtId));
        postEntity.setPostPublishTime(new Timestamp(System.currentTimeMillis()));
        postEntity = postRepository.save(postEntity);
        return convertPostEntityToPostViewModel(postEntity);
    }

    @Override
    public boolean deletePost(int postId)
    {
        PostEntity postEntity = postRepository.findOne(postId);
        if (postEntity == null)
        {
            return false;
        }
        postRepository.delete(postEntity);
        return true;
    }

    @Override
    public PostViewModel getPostByPostId(int postId)
    {
        PostEntity entity = postRepository.findOne(postId);
        if (entity == null)
        {
            return null;
        }
        return convertPostEntityToPostViewModel(entity);
    }

    private List<PostViewModel> convertPostEntitiesToPostViewModels(Page<PostEntity> postEntities)
    {
        List<PostViewModel> postViewModelList = new ArrayList<>(postEntities.getSize());
        postEntities.forEach(postEntity ->
        {
            PostViewModel postViewModel = convertPostEntityToPostViewModel(postEntity);
            postViewModelList.add(postViewModel);
        });
        return postViewModelList;
    }

    private PostViewModel convertPostEntityToPostViewModel(PostEntity postEntity)
    {
        PostViewModel postViewModel = new PostViewModel();
        postViewModel.setPostId(postEntity.getId());
        postViewModel.setPostAuthor(userService.getUserDetailInfo(postEntity.getPostAuthor()));
        postViewModel.setPostContent(postEntity.getPostContent());
        postViewModel.setPostPublishTime(postEntity.getPostPublishTime());
        postViewModel.setPostComments(postCommentService.getPostComments(postEntity.getId()));
        postViewModel.setPostUserLikes(postLikeService.getPostLikes(postEntity.getId()));
        List<Integer> artIds = IntegerSpliter.StrListToIntList(postEntity.getPostArts());
        List<ArtViewModel> artViewModels = new ArrayList<>(artIds.size());
        artIds.forEach(integer ->
        {
            ArtViewModel model = artService.getArtById(integer);
            artViewModels.add(model);
        });
        postViewModel.setPostArts(artViewModels);
        return postViewModel;
    }
}
