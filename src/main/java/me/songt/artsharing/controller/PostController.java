package me.songt.artsharing.controller;

import me.songt.artsharing.controller.reqbody.AddPostRequestBody;
import me.songt.artsharing.service.PostCommentService;
import me.songt.artsharing.service.PostLikeService;
import me.songt.artsharing.service.PostService;
import me.songt.artsharing.utils.IntegerSpliter;
import me.songt.artsharing.vo.PostCommentViewModel;
import me.songt.artsharing.vo.PostViewModel;
import me.songt.artsharing.vo.Result;
import me.songt.artsharing.vo.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tony on 2017/7/8.
 */
@RestController
public class PostController
{
    @Autowired
    private PostCommentService postCommentService;

    @Autowired
    private PostLikeService postLikeService;

    @Autowired
    private PostService postService;


    @GetMapping("/api/post/all")
    public ResponseEntity<?> getAllPosts(@RequestParam(defaultValue = "postPublishTime") String sortField,
                                         @RequestParam(defaultValue = "0") int pageIndex,
                                         @RequestParam(defaultValue = "10") int pageSize,
                                         @RequestParam(defaultValue = "0") int desc)
    {
        List<PostViewModel> postViewModelList = postService.getAllPosts(sortField, pageIndex, pageSize, desc == 1);
        if (postViewModelList == null)
        {
            return new ResponseEntity<Object>(new Result(false, "No Result"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(new Result(true, "Success", postViewModelList), HttpStatus.OK);

    }

    @GetMapping("/api/post/author/{authorId}")
    public ResponseEntity<?> getUserPosts(@PathVariable("authorId") int authorId,
                                          @RequestParam(defaultValue = "postPublishTime") String sortField,
                                          @RequestParam(defaultValue = "0") int pageIndex,
                                          @RequestParam(defaultValue = "10") int pageSize,
                                          @RequestParam(defaultValue = "0") int desc)
    {
        List<PostViewModel> postViewModelList = postService.getUserPosts(authorId, sortField, pageIndex, pageSize, desc == 1);
        if (postViewModelList == null)
        {
            return new ResponseEntity<Object>(new Result(false, "No Result"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(new Result(true, "Success", postViewModelList), HttpStatus.OK);
    }

    @PostMapping("/api/post")
    public ResponseEntity<?> addPost(@RequestBody AddPostRequestBody body)
    {
        PostViewModel model = postService.addPost(body.getAuthorId(), body.getPostContent(), IntegerSpliter.StrListToIntList(body.getPostArtId()));
        if (model == null)
        {
            return new ResponseEntity<Object>(new Result(false, "Add Failed"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(new Result(true, "Success", model), HttpStatus.OK);
    }

    @DeleteMapping("/api/post/id/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable("postId") int postId)
    {
        if (!postService.deletePost(postId))
        {
            return new ResponseEntity<Object>(new Result(false, "Delete Failed."), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(new Result(true, "Success"), HttpStatus.OK);
    }

    @GetMapping("/api/post/id/{postId}")
    public ResponseEntity<?> getPostByPostId(@PathVariable("postId") int postId)
    {
        PostViewModel model = postService.getPostByPostId(postId);
        if (model == null)
        {
            return new ResponseEntity<Object>(new Result(false, "No such post"),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(new Result(true, "Success", model), HttpStatus.OK);
    }

    @PostMapping("/api/post/id/{postId}/like")
    public ResponseEntity<?> likePost(@PathVariable("postId") int postId, @RequestParam("userId") int userId)
    {
        postLikeService.like(postId, userId);
        return new ResponseEntity<Object>(new Result(true, "Success"), HttpStatus.OK);
    }

    @PostMapping("/api/post/id/{postId}/dislike")
    public ResponseEntity<?> dislikePost(@PathVariable("postId") int postId, @RequestParam("userId") int userId)
    {
        postLikeService.dislike(postId, userId);
        return new ResponseEntity<Object>(new Result(true, "Success"), HttpStatus.OK);
    }

    @GetMapping("/api/post/id/{postId}/likes")
    public ResponseEntity<?> getPostLikes(@PathVariable("postId") int postId)
    {
        List<UserViewModel> users = postLikeService.getPostLikes(postId);
        if (users == null)
        {
            return new ResponseEntity<Object>(new Result(false, "No Result"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(new Result(true, "Success", users), HttpStatus.OK);
    }

    @PostMapping("/api/post/id/{postId}/comment")
    public ResponseEntity<?> addPostComment(@PathVariable("postId") int postId,
                                            @RequestParam("authorId") int authorId,
                                            @RequestParam("content") String content)
    {
        PostCommentViewModel model = postCommentService.addPostComment(postId, authorId, content);
        if (model == null)
        {
            return new ResponseEntity<Object>(new Result(false, "Add Failed"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(new Result(true, "Success", model), HttpStatus.OK);
    }

    @DeleteMapping("/api/post/comment/{postCommentId}")
    public ResponseEntity<?> deletePostComment(@PathVariable("postCommentId") int postCommentId)
    {
        if (!postCommentService.deletePostComment(postCommentId))
        {
            return new ResponseEntity<Object>(new Result(false, "Delete Failed."), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(new Result(true, "Success"), HttpStatus.OK);
    }

    @GetMapping("/api/post/comment/id/{postCommentId}")
    public ResponseEntity<?> getPostComment(@PathVariable("postCommentId") int postCommentId)
    {
        PostCommentViewModel model = postCommentService.getPostComment(postCommentId);
        if (model == null)
        {
            return new ResponseEntity<Object>(new Result(false, "No Such Comment"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(new Result(true, "Success", model), HttpStatus.OK);
    }

}
