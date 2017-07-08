package me.songt.artsharing.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/7/5.
 * Post Comment Database Entity
 */
@Entity
@Table(name = "post_comment")
public class PostCommentEntity
{
    private int id;
    private int postId;
    private int commentAuthorId;
    private String commentContent;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "post_id", nullable = false)
    public int getPostId()
    {
        return postId;
    }

    public void setPostId(int postId)
    {
        this.postId = postId;
    }

    @Basic
    @Column(name = "comment_author_id", nullable = false)
    public int getCommentAuthorId()
    {
        return commentAuthorId;
    }

    public void setCommentAuthorId(int commentAuthorId)
    {
        this.commentAuthorId = commentAuthorId;
    }

    @Basic
    @Column(name = "comment_content", nullable = false, length = 1000)
    public String getCommentContent()
    {
        return commentContent;
    }

    public void setCommentContent(String commentContent)
    {
        this.commentContent = commentContent;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        PostCommentEntity that = (PostCommentEntity) o;

        if (id != that.id)
        {
            return false;
        }
        if (postId != that.postId)
        {
            return false;
        }
        if (commentAuthorId != that.commentAuthorId)
        {
            return false;
        }
        return commentContent != null ? commentContent.equals(that.commentContent) : that.commentContent == null;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + postId;
        result = 31 * result + commentAuthorId;
        result = 31 * result + (commentContent != null ? commentContent.hashCode() : 0);
        return result;
    }
}
