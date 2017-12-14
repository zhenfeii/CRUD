package com.wyu.ui.entity;

/**
 * Created by Administrator on 2017/12/12 0012.
 */
public class Menu {
    String menuname;
    String url;

    public Menu(String menuname, String url) {
        this.menuname = menuname;
        this.url = url;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
