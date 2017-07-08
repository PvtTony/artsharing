package me.songt.artsharing.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/7/5.
 * Post Likes Database Entity
 */
@Entity
@Table(name = "post_likes")
public class PostLikesEntity
{
    private int id;
    private int postId;
    private int postLikeUserid;

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
    @Column(name = "post_like_userid", nullable = false)
    public int getPostLikeUserid()
    {
        return postLikeUserid;
    }

    public void setPostLikeUserid(int postLikeUserid)
    {
        this.postLikeUserid = postLikeUserid;
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

        PostLikesEntity that = (PostLikesEntity) o;

        if (id != that.id)
        {
            return false;
        }
        if (postId != that.postId)
        {
            return false;
        }
        return postLikeUserid == that.postLikeUserid;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + postId;
        result = 31 * result + postLikeUserid;
        return result;
    }
}
