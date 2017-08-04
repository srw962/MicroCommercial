package com.spider.microcommercial.dto.user;

import java.io.Serializable;
import java.util.Collection;

public class MenuItem implements Serializable {
    private static final long serialVersionUID = 8843257671063427332L;

    private Integer moduleId;   // 模块ID
    private String moduleName;  // 模块对应前端组件name
    private String title;       // 菜单标题
    private String icon;        // 模块图标
    private Collection<MenuItem> subItems;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Collection<MenuItem> getSubItems() {
        return subItems;
    }

    public void setSubItems(Collection<MenuItem> subItems) {
        this.subItems = subItems;
    }
}
