package com.github.raystorm.sample.session;

import com.github.raystorm.sample.daos.SampleUser;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;


public class SampleSession extends WebSession
{
    public static SampleSession get()
    { return (SampleSession) Session.get(); }

    private SampleUser user = null;

    public SampleSession(Request request) { super(request); }

    public SampleUser getUser() { return user; }

    public void setUser(SampleUser user) { this.user = user; }

    public boolean isAuthenticated() { return null == user; }

    public boolean isAnonymous()
    { return null == user || null == user.getUserName(); }

}
