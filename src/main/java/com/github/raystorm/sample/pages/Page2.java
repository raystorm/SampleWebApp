package com.github.raystorm.sample.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.github.raystorm.sample.panels.MenuPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("page2")
public class Page2 extends WebPage {

    public Page2()
    {
        super();
        add(new MenuPanel("menu", Page2.class));
    }

}