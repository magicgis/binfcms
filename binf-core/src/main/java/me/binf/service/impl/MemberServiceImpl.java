package me.binf.service.impl;

import me.binf.core.Constant;
import me.binf.dao.MemberDao;
import me.binf.entity.Member;
import me.binf.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wangbin on 14-10-16.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;


    @Override
    public List<Member> findAll() {
        return memberDao.findAll();
    }

    @Override
    public Page<Member> find(int pageNum, int pageSize) {
        return memberDao.findAll(new PageRequest(pageNum, pageSize, Sort.Direction.DESC, "id"));
    }

    @Override
    public Page<Member> find(int pageNum) {
        return find(pageNum, Constant.PAGE_DEF_SZIE);
    }

    @Override
    public Member getById(int id) {
        return memberDao.findOne(id);
    }

    @Override
    public Member deleteById(int id) {
        Member member = getById(id);
        memberDao.delete(member);
        return member;
    }

    @Override
    public Member create(Member member) {
        member.setCreateDate(new Date());
        return memberDao.save(member);
    }

    @Override
    public Member Update(Member member) {
        member.setUpdateDate(new Date());
        return memberDao.save(member);
    }

}
