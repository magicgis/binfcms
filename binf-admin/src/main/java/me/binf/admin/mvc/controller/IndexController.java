package me.binf.admin.mvc.controller;

import me.binf.dao.MemberDao;
import me.binf.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 14-10-11.
 */
@Controller
public class IndexController {

    @Autowired
    private MemberDao memberDao;

    @RequestMapping(value = "/")
    public String index(HttpServletRequest request,
                        HttpServletResponse response,
                        ModelMap model){
        List<Member> memberList =  memberDao.findAll();

        model.put("memberList",memberList);
        model.put("hello","hello");
        return "template/admin/控制面板";
    }


}
