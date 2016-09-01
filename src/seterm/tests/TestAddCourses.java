package seterm.tests;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import seterm.dao.*;
//import seterm.dao.Examsdao;

public class TestAddCourses {
	
	static String  id = null;
	static String cname = null;
		@BeforeClass
		public static void setup(){
			id="CSI 999";
			cname="Course";
		}
		@Test
	   public void testAddAnnouncements() {
			
			Coursesdao e = new Coursesdao();
			int count = e.saveCourseinfo(cname, id);
	      assertEquals(1, count);
	   }

}
