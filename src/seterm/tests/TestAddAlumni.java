package seterm.tests;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import seterm.dao.*;
//import seterm.dao.Examsdao;

public class TestAddAlumni {
	
	static String  fname = null;
	static String lname = null;
	static String info = null;
		@BeforeClass
		public static void setup(){
			fname="Bill";
			lname="Thomas";
			info="works at fb";
		}
		@Test
	   public void testAddAnnouncements() {
			
			Alumnidao e = new Alumnidao();
			int count = e.addAlumniInfo(fname, lname,info);
	      assertEquals(1, count);
	   }

}
