package me.songt.artsharing.controller.reqbody;

/**
 * Created by tony on 2017/7/8.
 * Add Post Request Body
 */
public class AddPostRequestBody
{
    private int authorId;
    private String postContent, postArtId;

    public AddPostRequestBody()
    {
    }

    public int getAuthorId()
    {
        return authorId;
    }

    public void setAuthorId(int authorId)
    {
        this.authorId = authorId;
    }

    public String getPostContent()
    {
        return postContent;
    }

    public void setPostContent(String postContent)
    {
        this.postContent = postContent;
    }

    public String getPostArtId()
    {
        return postArtId;
    }

    public void setPostArtId(String postArtId)
    {
        this.postArtId = postArtId;
    }
}
