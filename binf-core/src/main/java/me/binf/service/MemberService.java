package me.binf.service;

import me.binf.entity.Member;
import me.binf.service.common.ICommonService;

import java.util.List;

/**
 * Created by wangbin on 14-10-16.
 */
public interface MemberService extends ICommonService<Member> {

    List<Member> findByUsernameAndPassword(String username,String password);
}
