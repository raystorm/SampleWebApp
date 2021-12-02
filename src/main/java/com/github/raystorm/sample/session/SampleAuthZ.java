package com.github.raystorm.sample.session;

import com.github.raystorm.sample.pages.LoginPage;
import org.apache.wicket.Component;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.authentication.IAuthenticationStrategy;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.authorization.IUnauthorizedComponentInstantiationListener;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.component.IRequestableComponent;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.IResource;

/**
 * Authorization Strategy to stop secure page loads for Users who are not logged in.
 */
public class SampleAuthZ implements IAuthorizationStrategy,
                                    IUnauthorizedComponentInstantiationListener
{
    @Override
    public <T extends IRequestableComponent> boolean isInstantiationAuthorized(Class<T> componentClass)
    {
       if ( componentClass.isAssignableFrom(WebPage.class)
         && componentClass.getPackageName()
                          .startsWith("com.github.raystorm.sample.pages.secure"))
       { return SampleSession.get().isAuthenticated(); }
       return true;
    }

    //Duck, default pass the other AuthZ checks to the rest of the chain

    @Override
    public boolean isActionAuthorized(Component component, Action action)
    { return true; }

    @Override
    public boolean isResourceAuthorized(IResource resource, PageParameters parameters)
    { return true; }

    @Override
    public void onUnauthorizedInstantiation(Component component)
    { throw new RestartResponseAtInterceptPageException(LoginPage.class); }
}