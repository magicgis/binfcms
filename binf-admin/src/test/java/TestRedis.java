import me.binf.admin.cache.CacheService;
import me.binf.entity.Member;
import me.binf.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by wangbin on 14-10-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:/conf/spring-cache.xml"})
public class TestRedis {

    @Resource(name = "memberCacheServiceImpl")
    private CacheService<Member> memberCacheService;


    @Autowired
    private MemberService memberService;


    @Test
    public void test1(){
//        Member member = new Member();
//
//        member.setId(1);
//        member.setName("wangbin");
//
//        memberCacheService.put("wangbin", member);
//
//        Member member1 =memberCacheService.get("wangbin");
//
//        System.out.println(member1.getName().toString());
//        System.out.println(memberService.isLogin("wangbin"));



    }



}
