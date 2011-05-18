package com.fbs.web.vaadin.ui.admin;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.fbs.security.model.Tenant;
import com.fbs.web.vaadin.MyVaadinApplication;
import com.fbs.web.vaadin.i18n.ApplicationMessages;
import com.fbs.web.vaadin.ui.common.ItemsListScreen;
import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.TextField;

public class TenantsScreen extends ItemsListScreen<Tenant>
{
	private static final long serialVersionUID = 1L;
	private static final String COL_ID = "id";
	private static final String COL_DESCR = "description";
	private static String[] visibleColumns = new String[] { COL_ID, COL_DESCR };
	private static String[] visibleItemProperties = new String[] { COL_ID, COL_DESCR };


	public TenantsScreen(MyVaadinApplication app)
	{
		super(app, Tenant.class);
	}


	@Override
	protected Tenant createBeanInstance()
	{
		Tenant result;

		result = new Tenant();
		result.setDescription("");

		return result;
	}


	@Override
	protected List<Tenant> getAllBeans()
	{
		List<Tenant> result;

		result = this.app.getTenantService().findAll();

		return result;
	}


	@Override
	protected String[] getVisibleColumns()
	{
		return visibleColumns;
	}


	@Override
	protected String getColumnName(String propertyId)
	{
		if (propertyId.equals(COL_ID))
			return this.app.getMessage(ApplicationMessages.TenantId);

		if (propertyId.equals(COL_DESCR))
			return this.app.getMessage(ApplicationMessages.TenantDescription);

		return propertyId;
	}


	@Override
	protected void updateBean(Tenant t)
	{
		this.app.getTenantService().update(t);
	}


	@Override
	protected void deleteBean(Tenant t)
	{
		this.app.getTenantService().delete(t.getId());
	}


	@Override
	protected Tenant createBean(Tenant tenant)
	{
		Tenant result;

		result = this.app.getTenantService().create(tenant);

		return result;
	}


	@Override
	protected Tenant readBean(Tenant t)
	{
		Tenant result;

		result = this.app.getTenantService().read(t.getId());

		return result;
	}

	private static class TenantFormFieldFactory implements FormFieldFactory
	{
		private static final long serialVersionUID = 1L;
		private MyVaadinApplication app;
		
		public TenantFormFieldFactory(MyVaadinApplication app)
		{
			this.app = app;
		}

		@Override
		public Field createField(Item item, Object propertyId, Component uiContext)
		{
			// Identify the fields by their Property ID.
			TextField result = null;
			
			String pid = (String) propertyId;
			
			if (COL_ID.equals(pid))
			{
				result = new TextField(this.app.getMessage(ApplicationMessages.TenantId));
				
				result.setReadOnly(true);
			}
			else if (COL_DESCR.equals(pid))
			{
				result = new TextField(this.app.getMessage(ApplicationMessages.TenantDescription));
			}
			
			
			return result;
		}

	}

	@Override
    protected Collection<String> getVisibleItemProperties()
    {
	    return Arrays.asList(visibleItemProperties);
    }


	@Override
    protected FormFieldFactory getFormFieldFactory()
    {
	    return new TenantFormFieldFactory(this.app);
    }
}
