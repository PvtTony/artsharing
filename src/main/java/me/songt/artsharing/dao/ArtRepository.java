package me.songt.artsharing.dao;

import me.songt.artsharing.po.ArtEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tony on 2017/6/27.
 */
@Repository
public interface ArtRepository extends PagingAndSortingRepository<ArtEntity, Integer>
{
    Page<ArtEntity> findAllByArtAuthor(int authorId, Pageable pageable);
}
