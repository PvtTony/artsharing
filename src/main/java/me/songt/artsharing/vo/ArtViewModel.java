package me.songt.artsharing.vo;

/**
 * Created by tony on 2017/7/8.
 * Art ViewModel
 */
public class ArtViewModel
{
    private int artId;
    private String artName;
    private UserViewModel artAuthor;
    private String artPath;

    public ArtViewModel()
    {
    }

    public int getArtId()
    {
        return artId;
    }

    public void setArtId(int artId)
    {
        this.artId = artId;
    }

    public String getArtName()
    {
        return artName;
    }

    public void setArtName(String artName)
    {
        this.artName = artName;
    }

    public UserViewModel getArtAuthor()
    {
        return artAuthor;
    }

    public void setArtAuthor(UserViewModel artAuthor)
    {
        this.artAuthor = artAuthor;
    }

    public String getArtPath()
    {
        return artPath;
    }

    public void setArtPath(String artPath)
    {
        this.artPath = artPath;
    }
}
