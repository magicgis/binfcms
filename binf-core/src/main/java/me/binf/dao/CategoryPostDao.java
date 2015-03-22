package me.binf.dao;

import me.binf.entity.CategoryPost;
import me.binf.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * Created by wangbin on 14-11-16.
 */
public interface CategoryPostDao extends JpaRepository<CategoryPost,Integer> {


    @Modifying
    @Query("delete from CategoryPost a where a.post.id = ?1")
    public void deleteByPostId(Integer postId);

    @Query("select a from CategoryPost a where a.post.id = ?1")
    public List<CategoryPost> findByPost(Integer postId);

    @Modifying
    @Query("delete from CategoryPost a where a.category.id = ?1")
    public void deleteByCategory(Integer categoryId);

    @Query("select a from CategoryPost a where a.category.id = ?1")
    public List<CategoryPost> findByCategory(Integer categoryId);


    @Query("select a from CategoryPost a where a.post.id = ?1 and a.category.id =?2")
    public CategoryPost findByPostAndCate(Integer postId,Integer categoryId);

    @Query("select a.post from CategoryPost a where a.category.name = ?1")
    public Page<Post>  findByCategoryName(String name,Pageable pageable);

}
