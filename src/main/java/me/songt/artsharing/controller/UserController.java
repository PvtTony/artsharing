package me.songt.artsharing.controller;

import me.songt.artsharing.exception.AuthException;
import me.songt.artsharing.service.UserService;
import me.songt.artsharing.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tony on 2017/6/27.
 */
@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/api/user/auth")
    public ResponseEntity<?> auth(String email, String password)
    {

        try
        {
            return new ResponseEntity<Object>(new Result(true, "Success",
                    userService.auth(email, password)), HttpStatus.OK);
        } catch (AuthException e)
        {
            return new ResponseEntity<Object>(new Result(false, e.getMessage()),
                    HttpStatus.UNAUTHORIZED);
//            e.printStackTrace();
        }
    }


    @PostMapping("/api/user/register")
    public ResponseEntity<?> register(String email, String password)
    {
//        return new ResponseEntity<Object>(userService.register(email, password), HttpStatus.OK);
        return new ResponseEntity<Object>(new Result(true, "Success",
                userService.register(email, password)), HttpStatus.OK);
    }
}
