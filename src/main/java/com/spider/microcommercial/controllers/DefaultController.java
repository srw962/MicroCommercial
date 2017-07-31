package com.spider.microcommercial.controllers;

import com.spider.microcommercial.utils.EnvironmentProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class DefaultController {
    @Autowired
    EnvironmentProvider environmentProvider;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/")
    public ModelAndView index() {
        if (environmentProvider.isProduction()) {
            return new ModelAndView("forward://dist/index.html");
        } else {
            return new ModelAndView("forward://index.html");
        }
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("msg", "Hello, World");
        return "index";
    }
}
