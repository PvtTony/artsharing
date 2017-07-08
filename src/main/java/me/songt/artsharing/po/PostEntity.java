package me.songt.artsharing.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by tony on 2017/7/5.
 */
@Entity
@Table(name = "post")
public class PostEntity
{
    private int id;
    private int postAuthor;
    private String postContent;
    private String postArts;
    private Timestamp postPublishTime;

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
    @Column(name = "post_author", nullable = false)
    public int getPostAuthor()
    {
        return postAuthor;
    }

    public void setPostAuthor(int postAuthor)
    {
        this.postAuthor = postAuthor;
    }

    @Basic
    @Column(name = "post_content", nullable = true, length = 1000)
    public String getPostContent()
    {
        return postContent;
    }

    public void setPostContent(String postContent)
    {
        this.postContent = postContent;
    }

    @Basic
    @Column(name = "post_arts", nullable = true, length = 200)
    public String getPostArts()
    {
        return postArts;
    }

    public void setPostArts(String postArts)
    {
        this.postArts = postArts;
    }

    @Basic
    @Column(name = "post_publishtime", nullable = false)
    public Timestamp getPostPublishTime()
    {
        return postPublishTime;
    }

    public void setPostPublishTime(Timestamp postPublishTime)
    {
        this.postPublishTime = postPublishTime;
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

        PostEntity that = (PostEntity) o;

        if (id != that.id)
        {
            return false;
        }
        if (postAuthor != that.postAuthor)
        {
            return false;
        }
        if (postContent != null ? !postContent.equals(that.postContent) : that.postContent != null)
        {
            return false;
        }
        if (postArts != null ? !postArts.equals(that.postArts) : that.postArts != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + postAuthor;
        result = 31 * result + (postContent != null ? postContent.hashCode() : 0);
        result = 31 * result + (postArts != null ? postArts.hashCode() : 0);
        return result;
    }
}
