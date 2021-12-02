package com.github.raystorm.sample.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.github.raystorm.sample.panels.MenuPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("page3")
public class Page3 extends WebPage {

    public Page3()
    {
        super();
        add(new MenuPanel("menu", Page3.class));
    }

}