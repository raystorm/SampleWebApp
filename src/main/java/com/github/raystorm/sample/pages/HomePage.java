package com.github.raystorm.sample.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.github.raystorm.sample.panels.MenuPanel;
import org.apache.wicket.markup.html.WebPage;

@WicketHomePage
public class HomePage extends WebPage
{
    public HomePage()
    {
       super();
       add(new MenuPanel("menu", HomePage.class));
    }

}