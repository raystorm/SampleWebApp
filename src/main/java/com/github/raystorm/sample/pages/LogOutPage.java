package com.github.raystorm.sample.pages;

import org.apache.wicket.Page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("/logout")
public class LogOutPage extends WebPage
{
  public static final String REDIRECTPAGE_PARAM = "redirectpage";

  @SuppressWarnings("unchecked")
  public LogOutPage(final PageParameters parameters)
  {
    String page = parameters.get(REDIRECTPAGE_PARAM).toString();

    Class<? extends Page> pageClass;
    if (page != null)
    {
      try { pageClass = (Class<? extends Page>) Class.forName(page); }
      catch (ClassNotFoundException e) { throw new RuntimeException(e); }
    }
    else { pageClass = getApplication().getHomePage(); }

    getSession().invalidate();
    setResponsePage(pageClass);
  }
}
