package me.binf.dao;

import me.binf.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangbin on 14-10-14.
 */
public interface MemberDao extends JpaRepository<Member,Integer> {
}
