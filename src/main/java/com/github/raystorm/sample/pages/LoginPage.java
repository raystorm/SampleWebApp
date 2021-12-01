package com.github.raystorm.sample.pages;

import com.github.raystorm.sample.daos.SampleUserRepo;
import com.github.raystorm.sample.session.SampleSession;
import com.github.raystorm.sample.session.SampleUser;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("/login")
public class LoginPage extends WebPage
{
    @Autowired
    SampleUserRepo userRepo; //in a REAL app move to Service Layer

    private static class LoginForm extends StatelessForm
    {
        private String userName;
        private String pass;

        public LoginForm(String id)
        {
           super(id);
           setModel(new CompoundPropertyModel(this));
           add(new TextField<String>(userName));
           add(new PasswordTextField(pass));
        }

        @Override
        protected void onSubmit()
        {
           super.onSubmit();

           SampleUser user = null;
           if ( null != (user = userRepo.findByUserNameAndAndPass(userName, pass)))
           {
              SampleSession session = SampleSession.get();
              session.setUser(user);
              continueToOriginalDestination();
              //no original destination, head to home page
              setResponsePage(getApplication().getHomePage());
           }
           //error, if the user/pass combo fails
           // message doesn't confirm the username exists for an attacker
           else { error("Unknown Username."); }
        }
    }
}
