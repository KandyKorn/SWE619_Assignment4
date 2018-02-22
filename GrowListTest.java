package assignment4;
import org.junit.Assert;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;
class GrowListTest {

	@Test
	void contractFailTest() {
		//By default, this test should not return any error or failure, When the appropriate line is deleted in GrowList, this test should fail
		GrowList<String> testList1 = new GrowList<String>();
		testList1.add("cat");
		assertEquals("cat", testList1.get(0));
	}
	@Test
	void repOkTest() {
		//By default this should return an error, but NOT fail. When appropriate line is deleted in GrowList, this test should fail
		GrowList<String> testList2 = new GrowList<String>();
		testList2.add("cat");
		testList2.set(2, "dog");
		assertTrue(testList2.repOk() == true);
	}

}
