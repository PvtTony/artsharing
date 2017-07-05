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

        UserEntity that = (UserEntity) o;

        if (id != that.id)
        {
            return false;
        }
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null)
        {
            return false;
        }
        if (userPass != null ? !userPass.equals(that.userPass) : that.userPass != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userPass != null ? userPass.hashCode() : 0);
        return result;
    }
}
