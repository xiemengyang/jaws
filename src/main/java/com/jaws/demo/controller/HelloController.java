package com.jaws.demo.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @Package:        com.jaws.demo.controller
 * @ClassName:      HelloController
 * @Description:    描述
 * @Author:         jaws
 * @CreateDate:     22:55 22:55
 * @Version:        1.0
 */
public class HelloController implements Controller {

    public static final Log logger = LogFactory.getLog(HelloController.class);

    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest,
                                      javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        logger.info("handleRequest被调用");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hello World!你好世界");
        modelAndView.setViewName("/WEB-INF/content/welcome.jsp");
        return modelAndView;

    }
}
