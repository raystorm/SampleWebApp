package com.github.raystorm.sample;

import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication;
import com.giffing.wicket.spring.boot.starter.app.WicketBootWebApplication;
import com.github.raystorm.sample.pages.HomePage;
import com.github.raystorm.sample.session.SampleSession;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
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
   }

   @Override
   public Session newSession(Request request, Response response)
   { return new SampleSession(request); }

   @Override
   public Class<? extends Page> getHomePage() { return HomePage.class; }
}