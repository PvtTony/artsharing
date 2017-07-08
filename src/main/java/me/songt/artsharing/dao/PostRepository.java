package me.songt.artsharing.dao;

import me.songt.artsharing.po.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tony on 2017/7/5.
 */
@Repository
public interface PostRepository extends PagingAndSortingRepository<PostEntity, Integer>
{
    Page<PostEntity> findAll(Pageable pageable);

    Page<PostEntity> findByPostAuthor(int postAuthorId, Pageable pageable);
}
