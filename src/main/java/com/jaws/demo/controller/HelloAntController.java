package com.jaws.demo.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Package:        com.jaws.demo.controller
 * @ClassName:      HelloAntController
 * @Description:    描述
 * @Author:         jaws
 * @CreateDate:     11:22 11:22
 * @Version:        1.0
 */
@Controller
public class HelloAntController {

    public static final Log logger = LogFactory.getLog(HelloController.class);

    @RequestMapping(value = "/helloAnt")
    public ModelAndView helloAnt(){
        logger.info("HelloAntController-->helloAnt被调用!");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hello World!!!  Ant~~~~~");

        modelAndView.setViewName("/WEB-INF/content/welcome.jsp");
        return modelAndView;
    }
}
