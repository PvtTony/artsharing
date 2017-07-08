package me.songt.artsharing.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/6/27.
 * User Entity
 */
@Entity
@Table(name = "user")
public class UserEntity
{
    private int id;
    private String userEmail;
    private String userPass;
    private String userNick;

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
    @Column(name = "user_email", nullable = false, length = 50)
    public String getUserEmail()
    {
        return userEmail;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_pass", nullable = false, length = 50)
    public String getUserPass()
    {
        return userPass;
    }

    public void setUserPass(String userPass)
    {
        this.userPass = userPass;
    }

    @Basic
    @Column(name = "user_nick", nullable = false, length = 100)
    public String getUserNick()
    {
        return userNick;
    }

    public void setUserNick(String userNick)
    {
        this.userNick = userNick;
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

        UserEntity entity = (UserEntity) o;

        if (getId() != entity.getId())
        {
            return false;
        }
        if (!getUserEmail().equals(entity.getUserEmail()))
        {
            return false;
        }
        if (!getUserPass().equals(entity.getUserPass()))
        {
            return false;
        }
        return getUserNick().equals(entity.getUserNick());
    }

    @Override
    public int hashCode()
    {
        int result = getId();
        result = 31 * result + getUserEmail().hashCode();
        result = 31 * result + getUserPass().hashCode();
        result = 31 * result + getUserNick().hashCode();
        return result;
    }
}
