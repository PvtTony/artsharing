package me.songt.artsharing.vo;

import me.songt.artsharing.po.ArtEntity;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by tony on 2017/7/5.
 */
public class PostViewModel
{
    private int postId;
    private UserViewModel postAuthor;
    private String postContent;
    private Timestamp postPublishTime;
    private List<ArtViewModel> postArts;
    private List<PostCommentViewModel> postComments;
    private List<UserViewModel> postUserLikes;

    public PostViewModel()
    {
    }

    public int getPostId()
    {
        return postId;
    }

    public void setPostId(int postId)
    {
        this.postId = postId;
    }

    public UserViewModel getPostAuthor()
    {
        return postAuthor;
    }

    public void setPostAuthor(UserViewModel postAuthor)
    {
        this.postAuthor = postAuthor;
    }

    public String getPostContent()
    {
        return postContent;
    }

    public void setPostContent(String postContent)
    {
        this.postContent = postContent;
    }

    public List<ArtViewModel> getPostArts()
    {
        return postArts;
    }

    public void setPostArts(List<ArtViewModel> postArts)
    {
        this.postArts = postArts;
    }

    public List<PostCommentViewModel> getPostComments()
    {
        return postComments;
    }

    public void setPostComments(List<PostCommentViewModel> postComments)
    {
        this.postComments = postComments;
    }

    public List<UserViewModel> getPostUserLikes()
    {
        return postUserLikes;
    }

    public void setPostUserLikes(List<UserViewModel> postUserLikes)
    {
        this.postUserLikes = postUserLikes;
    }

    public Timestamp getPostPublishTime()
    {
        return postPublishTime;
    }

    public void setPostPublishTime(Timestamp postPublishTime)
    {
        this.postPublishTime = postPublishTime;
    }
}
