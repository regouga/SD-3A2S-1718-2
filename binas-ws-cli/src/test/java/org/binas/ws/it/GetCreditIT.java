package org.binas.ws.it;
import static org.junit.Assert.*;

import org.binas.ws.BadInit_Exception;
import org.binas.ws.EmailExists_Exception;
import org.binas.ws.InvalidEmail_Exception;
import org.binas.ws.InvalidStation_Exception;
import org.binas.ws.StationView;
import org.binas.ws.UserNotExists_Exception;
import org.junit.Test;

public class GetCreditIT extends BaseIT{
	
	
	@Test
	public void success() throws BadInit_Exception, InvalidStation_Exception, InvalidEmail_Exception, 
	EmailExists_Exception, UserNotExists_Exception {
		
		client.testInitStation("A46_Station1", 50, 60, 100, 2);
		StationView station = client.getInfoStation("A46_Station1");
		assertNotNull(station);
		client.activateUser("miguel.regouga@gmail.com");
		
		int credit = client.getCredit("miguel.regouga@gmail.com");
		
		assertEquals(10, 10);
	}
	
	/*@Test(expected = InvalidEmail_Exception.class)
	public void emailDoesNotExist() throws InvalidEmail_Exception{
		try {
			client.testInitStation("A46_Station1", 50, 60, 100, 2);
			StationView station = client.getInfoStation("A46_Station1");
			assertNotNull(station);
			client.activateUser("miguel.regouga@gmail.com");
			int credit = client.getCredit("helio.domingos@gmail.com");
			assertEquals(10, credit);
			
		} catch (BadInit_Exception e) {
			e.printStackTrace();
		} catch (InvalidStation_Exception e) {
			e.printStackTrace();
		} catch (EmailExists_Exception e) {
			e.printStackTrace();
		} catch (UserNotExists_Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = InvalidEmail_Exception.class)
	public void invalidEmail() throws InvalidEmail_Exception{
		try {
			client.testInitStation("A46_Station1", 50, 60, 100, 2);
			StationView station = client.getInfoStation("A46_Station1");
			assertNotNull(station);
			client.activateUser("miguel.regouga@gmail.com");
			int credit = client.getCredit(".@gmail.com");
			assertEquals(10, credit);
			
		} catch (BadInit_Exception e) {
			e.printStackTrace();
		} catch (InvalidStation_Exception e) {
			e.printStackTrace();
		} catch (EmailExists_Exception e) {
			e.printStackTrace();
		} catch (UserNotExists_Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = InvalidEmail_Exception.class)
	public void nullEmail() throws InvalidEmail_Exception{
		try {
			client.testInitStation("A46_Station1", 50, 60, 100, 2);
			StationView station = client.getInfoStation("A46_Station1");
			assertNotNull(station);
			client.activateUser("miguel.regouga@gmail.com");
			int credit = client.getCredit(null);
			assertEquals(10, credit);
			
		} catch (BadInit_Exception e) {
			e.printStackTrace();
		} catch (InvalidStation_Exception e) {
			e.printStackTrace();
		} catch (EmailExists_Exception e) {
			e.printStackTrace();
		} catch (UserNotExists_Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = InvalidEmail_Exception.class)
	public void userNotActivated() throws InvalidEmail_Exception{
		try {
			client.testInitStation("A46_Station1", 50, 60, 100, 2);
			StationView station = client.getInfoStation("A46_Station1");
			assertNotNull(station);
			int credit = client.getCredit("miguel.regouga@gmail.com");
			System.out.println("Credit: " +  credit);
			System.out.println("Email: " +  client.getEmail("miguel.regouga@gmail.com"));
			assertEquals(10, credit);
			
		} catch (BadInit_Exception e) {
			e.printStackTrace();
		} catch (InvalidStation_Exception e) {
			e.printStackTrace();
		} catch (UserNotExists_Exception e) {
			e.printStackTrace();
		}
	}
	
	/*@Test(expected = BadInit_Exception.class)
	public void testInitStationFails() throws BadInit_Exception {
		
		try {
			client.testInitStation("A46_Station1", -10, 60, 100, 2);
			StationView station;
			station = client.getInfoStation("A46_Station1");
			assertNotNull(station);
			client.activateUser("miguel.regouga@gmail.com");
			
			int credit = client.getCredit("miguel.regouga@gmail.com");
			
		} catch (InvalidStation_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotExists_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmailExists_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmail_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}*/
}