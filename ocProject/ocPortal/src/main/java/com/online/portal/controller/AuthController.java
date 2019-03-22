package com.online.portal.controller;

import com.online.common.web.JsonView;
import com.online.core.user.domain.AuthUser;
import com.online.core.user.service.IAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private IAuthUserService authUserService;

    /**
     * 注册页面
     */
    @RequestMapping(value = "/register")
    public ModelAndView register(){
        return new ModelAndView("auth/register");
    }

    /**
     * 实现注册
     */
    @RequestMapping(value = "/doRegister")
    @ResponseBody
    public String doRegister(AuthUser authUser){
        System.out.println(authUser.getUsername());
        AuthUser authUser1 =authUserService.getByUsername(authUser.getUsername());
        if (authUser1 != null){
            return JsonView.render(1);
        }else {
            authUserService.createSelectivity(authUser);
            return JsonView.render(0);
        }
    }
}
