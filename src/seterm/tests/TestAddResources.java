package seterm.tests;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import seterm.dao.*;
//import seterm.dao.Examsdao;

public class TestAddResources {
	
	static String  name = null;
	static String type = null;
	static String info = null;
		@BeforeClass
		public static void setup(){
			name="C05 Conference Room";
			type="Conference Room";
			info="works at fb";
		}
		@Test
	   public void testAddAnnouncements() {
			
			Resourcedao e = new Resourcedao();
			int count = e.saveResource(name, type,info);
	      assertEquals(1, count);
	   }

}
