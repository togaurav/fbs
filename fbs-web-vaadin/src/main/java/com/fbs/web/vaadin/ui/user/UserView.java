package com.fbs.web.vaadin.ui.user;

import com.fbs.web.vaadin.MyVaadinApplication;
import com.fbs.web.vaadin.ui.auth.LogoutListener;
import com.fbs.security.service.Authentication;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class UserView extends VerticalLayout
{
	private static final long serialVersionUID = 1L;
	private MyVaadinApplication app;
	Label demo;


	public UserView(final MyVaadinApplication app)
	{
		super();
		this.app = app;

		Authentication user = (Authentication) app.getUser();
		this.demo = new Label("Du hast dich als" + user.getPrincipal() + " eingelogt");

		Button create = new Button("Create items", new CreateListener(app, this));
		Button show = new Button("Show items", new ShowListener(app, this));

		Button logout = new Button("logout");
		logout.addListener(new LogoutListener(app));

		
		this.addComponent(demo);
		this.addComponent(show);
		this.addComponent(create);
		this.addComponent(logout);
	}

	private static class CreateListener implements Button.ClickListener
	{
		private static final long serialVersionUID = 1L;
		MyVaadinApplication app;
		UserView userView;


		public CreateListener(MyVaadinApplication app, UserView userView)
		{
			this.app = app;
			this.userView = userView;
		}


		@Override
		public void buttonClick(ClickEvent event)
		{
			app.doCreate();
		}

	}
	
	private static class ShowListener implements Button.ClickListener
	{
		private static final long serialVersionUID = 1L;
		MyVaadinApplication app;
		UserView userView;


		public ShowListener(MyVaadinApplication app, UserView userView)
		{
			this.app = app;
			this.userView = userView;
		}


		@Override
		public void buttonClick(ClickEvent event)
		{
			app.doShow();
		}

	}
}
