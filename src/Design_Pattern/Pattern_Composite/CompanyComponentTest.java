package Design_Pattern.Pattern_Composite;

import static org.junit.Assert.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;




public class CompanyComponentTest {
	CompanyComponent c1 = new Corporation("c1", 500);
	CompanyComponent c2 = new Corporation("c2", 300);
	CompanyComponent c3 = new Corporation("c2", 300);
	CompanyComponent f1 = new Franchise("f1", 200);
	CompanyComponent f2 = new Franchise("f2", 100);

	@Test
	public void testAdd() {
		c1.add(c2);
		c2.add(f1);
		c2.add(f2);

		assertEquals(1100, c1.getAggreateSum(), 0);
		assertEquals(600, c2.getAggreateSum(), 0);
		assertEquals(200, f1.getAggreateSum(), 0);


	}

	@Test
	public void testRemove() {
		c1.add(c2);
		c2.add(f1);
		c2.add(f2);
		c1.remove(f1);
		//can't remove something two levels below, no change
		assertEquals(1100, c1.getAggreateSum(), 0);
		c1.remove(c2);
		assertEquals(500, c1.getAggreateSum(), 0);


		
	}

	@Test
	public void testGetChild() {
		c1.add(c2);
		c1.add(f1);
		c2.add(f2);
		assertEquals("Result", "c2", c1.getChild(0).getName());
		assertEquals("Result", "f1", c1.getChild(1).getName());
		assertEquals("Result", "f2", c2.getChild(0).getName());


	//	System.out.println(c1.getChild(0).getName());
		
	}

	@Test
	public void testGetName() {
		assertEquals("Result", "c1", c1.getName());
		assertEquals("Result", "f1", f1.getName());
	}

	@Test
	public void testGetWorth() {
	
		assertEquals(500, c1.getWorth(), 0);
		assertEquals(200, f1.getWorth(), 0);

	}

	@Test
	public void testGetAggreateSum() {
		c1.add(c2);
		c2.add(f1);
		c2.add(f2);
		assertEquals(1100, c1.getAggreateSum(), 0);
		assertEquals(600, c2.getAggreateSum(), 0);
		assertEquals(200, f1.getAggreateSum(), 0);
	}

	@Test
	public void testPrint() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent)); 
		c1.print();
		f1.print();
		assertEquals("CORPORATION, Name:c1, worth 500.0 million\r\nFRANCHISE, Name:f1, 200.0 million\r\n", outContent.toString());
	}

}
