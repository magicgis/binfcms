package me.binf.admin.service.impl;

import me.binf.admin.cache.CacheService;
import me.binf.admin.core.Constant;
import me.binf.admin.service.LoginService;
import me.binf.entity.Member;
import me.binf.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wangbin on 14-10-31.
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Resource(name = "memberCacheServiceImpl")
    private CacheService<Member> cacheService;

    @Autowired
    private MemberService memberService;

    @Override
    public Boolean isLogin(String username) {
        return cacheService.isExist(username);
    }

    @Override
    public Boolean login(String username, String password,HttpServletRequest request) {

        List<Member> memberList =memberService.findByUsernameAndPassword(username,password);
        if(memberList!=null&&memberList.size()>0){
            Member member =  memberList.get(0);
            cacheService.put(member.getUsername(),member);
            request.getSession().setAttribute(Constant.SESSION_MEMBER,member.getUsername());
            return true;
        }
        return false;
    }

    @Override
    public Member getMember(HttpServletRequest request) {

        String username =  request.getSession().getAttribute(Constant.SESSION_MEMBER).toString();

        Member member = cacheService.get(username);

        return member;
    }


}
