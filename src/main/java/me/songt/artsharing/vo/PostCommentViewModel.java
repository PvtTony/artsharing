package me.songt.artsharing.vo;

/**
 * Created by tony on 2017/7/5.
 * Post Comment ViewModel
 */
public class PostCommentViewModel
{
    private int id;
    private UserViewModel commentAuthor;
    private String commentContent;

    public PostCommentViewModel(int id, String commentContent)
    {
        this.id = id;
        this.commentContent = commentContent;
    }

    public PostCommentViewModel()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public UserViewModel getCommentAuthor()
    {
        return commentAuthor;
    }

    public void setCommentAuthor(UserViewModel commentAuthor)
    {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentContent()
    {
        return commentContent;
    }

    public void setCommentContent(String commentContent)
    {
        this.commentContent = commentContent;
    }
}
