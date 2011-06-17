package com.fbs.dmr.universal.test.service.contact;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.fbs.dmr.universal.model.contact.PostalAddress;
import com.fbs.dmr.universal.model.geoboundary.City;
import com.fbs.dmr.universal.model.geoboundary.Country;
import com.fbs.dmr.universal.model.geoboundary.PostalCode;
import com.fbs.dmr.universal.model.geoboundary.State;
import com.fbs.dmr.universal.service.CrudService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CrudServicePostalAddressTest
{
	@Resource(name = "crudServicePostalAddress")
	CrudService<PostalAddress, Integer> crudServicePostalAddress;

	@Before
	public void setUp()
	{
		Assert.assertNotNull(crudServicePostalAddress);
	}

	@Test
	public void testCrud()
	{
		PostalAddress postalAddress;
		String address1 = "address1";
		// Details
		Country country;
		State state;
		City city;
		PostalCode postalCode;

		postalAddress = new PostalAddress();
		postalAddress.setAddress1(address1);

		// Add country to postal address
		country = new Country();
		country.setName("Big Country");

		state = new State();
		state.setName("Small State");
		state.setCountry(country);

		city = new City();
		city.setName("Big City");
		city.setState(state);

		postalCode = new PostalCode();
		postalCode.setCode("1234567");
		postalCode.setCountry(country);

		this.crudServicePostalAddress.create(postalAddress);
		Assert.assertNotNull(postalAddress.getId());
	}
}