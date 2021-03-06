package me.binf.dao;

import me.binf.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * Created by wangbin on 14-10-16.
 */
public interface CategoryDao extends JpaRepository<Category,Integer> {

    @Query("select a from Category a where a.parentId = ?1 order by a.level,a.sort desc")
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    public List<Category> findByParent(Integer parentId);

    @Query("select a from Category a where a.parentId is null order by a.level,a.sort desc")
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    public List<Category> findByParent();

    @Query("select a from Category a where a.level = ?1 order by a.sort desc")
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    public List<Category> findByLevel(int level);

    @Query("select a from Category a where a.isDef = true ")
    public Category findCategoryByDef();
}
