package me.songt.artsharing.service.impl;

import me.songt.artsharing.dao.UserRepository;
import me.songt.artsharing.exception.AuthException;
import me.songt.artsharing.po.UserEntity;
import me.songt.artsharing.service.UserService;
import me.songt.artsharing.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tony on 2017/6/28.
 */
@Service
public class UserServiceImpl implements UserService
{
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public Result auth(String email, String password) throws AuthException
    {
        Result result;
        UserEntity entity = userRepository.findByUserEmail(email);
        if (entity == null)
        {
            throw new AuthException("No Such User");
            /*result = new Result(false, "No Such User", null);
            return result;*/
        }
        if (!entity.getUserPass().equals(password))
        {
            throw new AuthException("Wrong Password");
            /*result = new Result(false, "Wrong Password.", null);
            return result;*/
        }
        result = new Result(true, "Authorized", entity);
        return result;
    }

    @Override
    public Result register(String email, String password)
    {
        Result result;
        UserEntity entity = new UserEntity();
        entity.setUserEmail(email);
        entity.setUserPass(password);
        userRepository.save(entity);
        return new Result(true, "Register Success", entity);
    }
}
