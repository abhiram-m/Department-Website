package seterm.tests;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import seterm.dao.*;
//import seterm.dao.Examsdao;

public class Testlogin {
	
	static String  netid = null;
	static String pwd = null;
		@BeforeClass
		public static void setup(){
			netid="KM111111";
			pwd="abhi";
		}
		@Test
	   public void testAddAnnouncements() {
			
			Logindao e = new Logindao();
			int count = e.loginAuth(netid, pwd);
	      assertEquals(1, count);
	   }

}
