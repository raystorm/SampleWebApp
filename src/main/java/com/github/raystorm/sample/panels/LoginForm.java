package com.github.raystorm.sample.panels;

import com.github.raystorm.sample.daos.SampleUserRepo;
import com.github.raystorm.sample.session.SampleSession;
import com.github.raystorm.sample.daos.SampleUser;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class LoginForm extends StatelessForm
{
    @SpringBean
    private SampleUserRepo userRepo;

    private String userName;
    private String pass;

    public LoginForm(final String id)
    {
       super(id);
       setModel(new CompoundPropertyModel(this));
       add(new TextField<String>("userName"));
       add(new PasswordTextField("pass"));
    }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPass() { return pass; }

    public void setPass(String pass) { this.pass = pass; }

    @Override
    protected void onSubmit()
    {
        super.onSubmit();

        SampleUser user = null;
        if ( null != (user = userRepo.findByUserNameAndPass(userName, pass)))
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
