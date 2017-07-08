package me.songt.artsharing.service;

import me.songt.artsharing.exception.AuthException;
import me.songt.artsharing.vo.Result;
import me.songt.artsharing.vo.UserViewModel;
import org.springframework.stereotype.Service;

/**
 * Created by tony on 2017/6/27.
 */
@Service
public interface UserService
{
    public UserViewModel auth(String email, String password) throws AuthException;

    public UserViewModel register(String email, String password);

    UserViewModel getUserDetailInfo(int userId);
}
