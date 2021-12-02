package com.github.raystorm.sample.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketSignInPage;
import com.github.raystorm.sample.panels.LoginForm;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * Page for logging into the application
 */
@WicketSignInPage
@MountPath("/login")
public class LoginPage extends WebPage
{

    public LoginPage()
    {
       super();
       add(new LoginForm("login"));
       add(new FeedbackPanel("feedback"));
    }
}
