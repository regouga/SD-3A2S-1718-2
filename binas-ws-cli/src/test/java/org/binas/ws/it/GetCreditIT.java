package org.binas.ws.it;
import static org.junit.Assert.*;

import org.binas.ws.BadInit_Exception;
import org.binas.ws.EmailExists_Exception;
import org.binas.ws.InvalidEmail_Exception;
import org.binas.ws.InvalidStation_Exception;
import org.binas.ws.StationView;
import org.binas.ws.UserNotExists_Exception;
import org.junit.After;
import org.junit.Test;

public class GetCreditIT extends BaseIT{
	
	
	@Test
	public void success() throws BadInit_Exception, InvalidStation_Exception, InvalidEmail_Exception, 
	EmailExists_Exception, UserNotExists_Exception {
		
		client.testInitStation("A46_Station1", 22, 7, 6, 2);
		StationView station = client.getInfoStation("A46_Station1");
		assertNotNull(station);
		client.activateUser("miguel.regouga@gmail.com");
		
		int credit = client.getCredit("miguel.regouga@gmail.com");
		
		assertEquals(10, credit);
	}
	
	@Test(expected = UserNotExists_Exception.class)
	public void emailDoesNotExist() throws InvalidEmail_Exception, BadInit_Exception, InvalidStation_Exception, EmailExists_Exception, UserNotExists_Exception{
		client.testInitStation("A46_Station1", 22, 7, 6, 2);
		StationView station = client.getInfoStation("A46_Station1");
		assertNotNull(station);
		client.activateUser("miguel.regouga@gmail.com");
		int credit = client.getCredit("helio.domingos@gmail.com");
		assertEquals(10, credit);
			
	}
	
	@Test(expected = UserNotExists_Exception.class)
	public void nullEmail() throws InvalidEmail_Exception, BadInit_Exception, InvalidStation_Exception, EmailExists_Exception, UserNotExists_Exception{
		client.testInitStation("A46_Station1", 22, 7, 6, 2);
		StationView station = client.getInfoStation("A46_Station1");
		assertNotNull(station);
		client.activateUser("miguel.regouga@gmail.com");
		int credit = client.getCredit(null);
		assertEquals(10, credit);
			
	}
	
	@Test(expected = UserNotExists_Exception.class)
	public void userNotActivated() throws InvalidEmail_Exception, BadInit_Exception, InvalidStation_Exception, UserNotExists_Exception{
		client.testInitStation("A46_Station1", 22, 7, 6, 2);
		StationView station = client.getInfoStation("A46_Station1");
		assertNotNull(station);
		int credit = client.getCredit("joao.pina@gmail.com");
		assertEquals(10, credit);
			
	}
	
	@Test(expected = UserNotExists_Exception.class)
	public void emptyEmail() throws InvalidEmail_Exception, BadInit_Exception, InvalidStation_Exception, EmailExists_Exception, UserNotExists_Exception{
		client.testInitStation("A46_Station1", 22, 7, 6, 2);
		StationView station = client.getInfoStation("A46_Station1");
		assertNotNull(station);
		client.activateUser("miguel.regouga@gmail.com");
		int credit = client.getCredit("");
		assertEquals(10, credit);
			
	}
	
	@Test(expected = UserNotExists_Exception.class)
	public void spaceEmail() throws InvalidEmail_Exception, BadInit_Exception, InvalidStation_Exception, EmailExists_Exception, UserNotExists_Exception{
		client.testInitStation("A46_Station1", 22, 7, 6, 2);
		StationView station = client.getInfoStation("A46_Station1");
		assertNotNull(station);
		client.activateUser("miguel.regouga@gmail.com");
		int credit = client.getCredit(" ");
		assertEquals(10, credit);	
	}
	
	@After
	public void tearDown() {
		client.testClear();
	}
	
}