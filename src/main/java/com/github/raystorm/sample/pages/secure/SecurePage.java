package com.github.raystorm.sample.pages.secure;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("/secure/page")
public class SecurePage extends WebPage {

    public SecurePage()
    {
        super();
    }

}