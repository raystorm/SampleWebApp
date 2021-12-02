package com.github.raystorm.sample.panels;

import com.github.raystorm.sample.daos.SampleUser;
import com.github.raystorm.sample.daos.SampleUserRepo;
import com.github.raystorm.sample.pages.Page1;
import com.github.raystorm.sample.pages.Page2;
import com.github.raystorm.sample.pages.Page3;
import com.github.raystorm.sample.session.SampleSession;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class MenuPanel extends Panel
{
    public MenuPanel(String id, Class<? extends Page> currentPageClass)
    {
       super(id);

       SampleUser user = SampleSession.get().getUser();
       String personName = null != user ? user.getName() : "Anonymous";

       //TODO: In a REAL App swap the manual name lookup for a proper Model Expression
       add(new Label("name", personName));

       add(new BookmarkablePageLink("page1", Page1.class));
       add(new BookmarkablePageLink("page2", Page2.class));
       add(new BookmarkablePageLink("page3", Page3.class));
    }


}
