package me.songt.artsharing.vo;

/**
 * Created by tony on 2017/7/5.
 * User View Model
 */
public class UserViewModel
{
    private int userId;
    private String email;
    private String nickname;

    public UserViewModel()
    {
    }

    public UserViewModel(int userId, String email, String nickname)
    {
        this.userId = userId;
        this.email = email;
        this.nickname = nickname;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    @Override
    public String toString()
    {
        return "UserViewModel{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
