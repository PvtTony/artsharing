package me.songt.artsharing.dao;

import me.songt.artsharing.po.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tony on 2017/6/27.
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>
{
    UserEntity findByUserEmail(String email);

}
