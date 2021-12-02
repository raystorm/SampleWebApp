package com.github.raystorm.sample;

import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication;
import com.giffing.wicket.spring.boot.starter.app.WicketBootWebApplication;
import com.github.raystorm.sample.pages.HomePage;
import com.github.raystorm.sample.pages.LoginPage;
import com.github.raystorm.sample.pages.secure.BaseSecuredPage;
import com.github.raystorm.sample.session.SampleAuthZ;
import com.github.raystorm.sample.session.SampleSession;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.authorization.strategies.page.SimplePageAuthorizationStrategy;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.springframework.stereotype.Component;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;

/**
 *  Setup the Application
 *
 *  TODO: REAL APP Integrate and Leverage Spring-Security
 */
@Component
public class SampleSecuredWicketApplication extends WicketBootStandardWebApplication
       //extends WicketBootSecuredWebApplication
{
   @Override
   protected void init()
   {
      super.init();
      new AnnotatedMountScanner()
            .scanPackage("com.github.raystorm.sample.pages")
            .mount(this);

      SampleAuthZ authorizationStrat = new SampleAuthZ();

      //getSecuritySettings().setAuthorizationStrategy(authorizationStrat);
      getSecuritySettings().setAuthorizationStrategy(new SimplePageAuthorizationStrategy(BaseSecuredPage.class, LoginPage.class) {
         @Override
         protected boolean isAuthorized()
         { return SampleSession.get().isAuthenticated(); }
      });

      getSecuritySettings().setUnauthorizedComponentInstantiationListener(authorizationStrat);
   }

   @Override
   public Session newSession(Request request, Response response)
   { return new SampleSession(request); }

   @Override
   public Class<? extends Page> getHomePage() { return HomePage.class; }
}