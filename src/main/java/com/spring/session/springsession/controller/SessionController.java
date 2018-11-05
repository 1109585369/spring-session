package com.spring.session.springsession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yy
 * @ProjectName spring-session
 * @Description: TODO
 * @date 2018/11/5 10:59
 */

@RequestMapping(value = "/")
@Controller
public class SessionController {



    @RequestMapping("session")
    @ResponseBody
    public Map<String,Object> getSession(HttpServletRequest request){

        request.getSession().setAttribute("userName","glmapper");
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("sessionId",request.getSession().getId());
        return map;
    }

    @RequestMapping(value = "/get")
    @ResponseBody
    public String get(HttpServletRequest request){
        String userName = (String) request.getSession().getAttribute("userName");
        return userName;
    }



}
