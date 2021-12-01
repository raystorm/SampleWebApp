package com.github.raystorm.sample.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("page2")
public class Page2 extends WebPage {

    public Page2()
    {
        super();
    }

}