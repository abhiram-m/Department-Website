package seterm.tests;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import seterm.dao.*;
//import seterm.dao.Examsdao;

public class TestAddAnnouncement {
	
	static String  id = null;
	static String datenow = null;
		@BeforeClass
		public static void setup(){
			Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf = 
			new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 id = ((sdf.format(dt).replace("-", "")).replace(":", "")).replace(" ", "");
			 datenow = sdf.format(dt);
		}
		@Test
	   public void testAddAnnouncements() {
			
			Announcementsdao e = new Announcementsdao();
			int count = e.saveAnnouncements("KM111111", "Eventnew", "event", id, datenow, "");
	      assertEquals(1, count);
	   }

}
