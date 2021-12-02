package com.github.raystorm.sample;

import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication;
import com.giffing.wicket.spring.boot.starter.app.WicketBootWebApplication;
import org.apache.wicket.Session;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.springframework.stereotype.Component;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;

/**
 *  Setup the Application
 */
@Component
public class SampleSecuredWicketApplication extends WicketBootStandardWebApplication
       //extends WicketBootSecuredWebApplication //TODO: REAL APP Integrate and Leverage Spring-Security
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
   { return super.newSession(request, response); }

}
