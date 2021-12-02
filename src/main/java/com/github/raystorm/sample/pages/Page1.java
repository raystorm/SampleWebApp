package com.github.raystorm.sample.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.github.raystorm.sample.panels.MenuPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("page1")
public class Page1 extends WebPage {

    public Page1()
    {
        super();
        add(new MenuPanel("menu", Page1.class));
    }
}