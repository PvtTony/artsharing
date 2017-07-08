package me.songt.artsharing.service;

import me.songt.artsharing.vo.PostViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 2017/7/5.
 */
@Service
public interface PostService
{
    List<PostViewModel> getAllPosts(String sortField, int pageIndex, int pageSize, boolean desc);

    List<PostViewModel> getUserPosts(int authorId, String sortField, int pageIndex, int pageSize, boolean desc);

    PostViewModel addPost(int authorId, String postContent, List<Integer> postArtId);

    boolean deletePost(int postId);

    PostViewModel getPostByPostId(int postId);
}
