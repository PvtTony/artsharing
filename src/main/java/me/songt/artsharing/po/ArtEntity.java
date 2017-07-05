package me.songt.artsharing.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/6/27.
 * Art Entity
 */
@Entity
@Table(name = "art")
public class ArtEntity
{
    private int id;
    private String artName;
    private int artAuthor;
    private String artPath;

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
    @Column(name = "art_name", nullable = false, length = 50)
    public String getArtName()
    {
        return artName;
    }

    public void setArtName(String artName)
    {
        this.artName = artName;
    }

    @Basic
    @Column(name = "art_author", nullable = false)
    public int getArtAuthor()
    {
        return artAuthor;
    }

    public void setArtAuthor(int artAuthor)
    {
        this.artAuthor = artAuthor;
    }

    @Basic
    @Column(name = "art_path", nullable = false, length = 255)
    public String getArtPath()
    {
        return artPath;
    }

    public void setArtPath(String artPath)
    {
        this.artPath = artPath;
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

        ArtEntity artEntity = (ArtEntity) o;

        if (id != artEntity.id)
        {
            return false;
        }
        if (artAuthor != artEntity.artAuthor)
        {
            return false;
        }
        if (artName != null ? !artName.equals(artEntity.artName) : artEntity.artName != null)
        {
            return false;
        }
        if (artPath != null ? !artPath.equals(artEntity.artPath) : artEntity.artPath != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (artName != null ? artName.hashCode() : 0);
        result = 31 * result + artAuthor;
        result = 31 * result + (artPath != null ? artPath.hashCode() : 0);
        return result;
    }
}
