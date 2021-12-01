package com.github.raystorm.sample.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("page3")
public class Page3 extends WebPage {

    public Page3()
    {
        super();
    }

}