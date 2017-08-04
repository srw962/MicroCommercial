package com.spider.microcommercial.controllers;

import com.google.common.collect.Lists;
import com.spider.microcommercial.dto.user.MenuItem;
import com.spider.microcommercial.utils.EnvironmentProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @RequestMapping("/getMenu")
    public @ResponseBody List<MenuItem> getMenu(String userName) {
        List<MenuItem> topMenu = Lists.newArrayList();
//        MenuItem menuItem = new MenuItem();
//        menuItem.setModuleId(1);
//        menuItem.setModuleName("");
//        menuItem.setTitle("菜单示例");
//        menuItem.setSubItems(Lists.newArrayList());
//        topMenu.add(menuItem);

        MenuItem chatMenu = new MenuItem();
        chatMenu.setModuleId(11);
        chatMenu.setModuleName("Chat");
        chatMenu.setTitle("Chat");

        MenuItem counterMenu = new MenuItem();
        counterMenu.setModuleId(12);
        counterMenu.setModuleName("Counter");
        counterMenu.setTitle("Counter");

        MenuItem fooMenu = new MenuItem();
        fooMenu.setModuleId(13);
        fooMenu.setModuleName("Foo");
        fooMenu.setTitle("Foo");

        topMenu.add(chatMenu);
        topMenu.add(counterMenu);
        topMenu.add(fooMenu);

        return topMenu;
    }
}
