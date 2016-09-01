package seterm.tests;
import static org.junit.Assert.*;

import org.junit.Test;

import seterm.dao.Examsdao;

public class TestAddExam {
	
	
		@Test
	   public void testAddExams() {
			Examsdao e = new Examsdao();
			int count = e.saveExam("Exam1", "2105/02/18", "Final", "AM111111");
	      assertEquals(1, count);
	   }

}
