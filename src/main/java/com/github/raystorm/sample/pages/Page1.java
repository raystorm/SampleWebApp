package com.github.raystorm.sample.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("page1")
public class Page1 extends WebPage {

    public Page1()
    {
        super();
    }

}