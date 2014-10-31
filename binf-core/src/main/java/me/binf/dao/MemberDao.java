package me.binf.dao;

import me.binf.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wangbin on 14-10-14.
 */
public interface MemberDao extends JpaRepository<Member,Integer> {


    @Query("select a from Member a where a.username = ?1 and a.password = ?2")
    List<Member> findByUsernameAndPassword(String username,String password);

}
