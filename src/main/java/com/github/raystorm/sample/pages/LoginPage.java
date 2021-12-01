package com.github.raystorm.sample.pages;

import com.github.raystorm.sample.daos.SampleUserRepo;
import com.github.raystorm.sample.panels.LoginForm;
import com.github.raystorm.sample.session.SampleSession;
import com.github.raystorm.sample.session.SampleUser;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * Page for logging into the application
 */
@MountPath("/login")
public class LoginPage extends WebPage
{
    @Autowired
    SampleUserRepo userRepo; //in a REAL app move to Service Layer


    public LoginPage()
    {
       super();
       add(new LoginForm("login"));
    }
}
