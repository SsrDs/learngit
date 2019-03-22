package com.online.portal.controller;


import com.online.core.consts.domain.ConstsSiteCarousel;
import com.online.core.consts.service.ISiteCarouselService;
import com.online.core.user.domain.User;
import com.online.core.user.service.IUserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping()
public class PortalController {
    @Autowired
    private IUserTest userTest;

    @Autowired
    private ISiteCarouselService siteCarouselService;

    /**
     * 进入主页
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(){
        //加载轮播图片
        List<ConstsSiteCarousel> carouselList = siteCarouselService.queryCarousels(4);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("carouselList",carouselList);
        return mv;
    }

    /**
     * 测试代码
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/test")
    public ModelAndView register(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println("111111111111"+username);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userTest.register(user);
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
