package com.spider.microcommercial.controllers.rest;

import com.google.common.collect.Lists;
import com.spider.microcommercial.dto.user.MenuItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserController {
    @RequestMapping("/getMenu")
    public @ResponseBody
    List<MenuItem> getMenu(String userName) {
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

        MenuItem ajaxMenu = new MenuItem();
        ajaxMenu.setModuleId(13);
        ajaxMenu.setModuleName("AjaxTest");
        ajaxMenu.setTitle("AjaxTest");

        MenuItem fooMenu = new MenuItem();
        fooMenu.setModuleId(14);
        fooMenu.setModuleName("Foo");
        fooMenu.setTitle("Foo");

        topMenu.add(chatMenu);
        topMenu.add(counterMenu);
        topMenu.add(ajaxMenu);
        topMenu.add(fooMenu);

        return topMenu;
    }
}
