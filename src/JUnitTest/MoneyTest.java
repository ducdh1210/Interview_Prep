package JUnitTest;

import static org.junit.Assert.*;

import java.util.Currency;

import org.junit.Before;
import org.junit.Test;

// 76.92% Test Coverage

public class MoneyTest {

	Currency Euro = Currency.getInstance("EUR");
	Currency USD = Currency.getInstance("USD");
	
	Money money1 = new Money(500, Euro);
	Money money2 = new Money(700, Euro);
	
	Money money3 = new Money(10000, USD);
	Money money4 = new Money(700, USD);

	@Test
	public void testGetAmount() {
		assertEquals("Result",500,money1.getAmount());
		assertEquals("Result",700,money2.getAmount());
		assertEquals("Result",10000,money3.getAmount());
		assertEquals("Result",700,money4.getAmount());
	}

	@Test
	public void testTenToPower(){
		assertEquals("Result",100,money1.tenToPower(2));
	}
	@Test
	public void testGetCurrency() {
		assertEquals("Result",USD,money4.getCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("Result","-2.00EUR",money1.minus(money2).toString());
		assertEquals("Result","93.00USD",money3.minus(money4).toString());
	}

	@Test
	public void testCompareTo() {
		assertEquals("Result",1,money2.CompareTo(money1));
		assertEquals("Result",-1,money1.CompareTo(money2));
		assertEquals("Result",0,money2.CompareTo(money4));
	}

	@Test
	public void testPlus() {
		money1.plus(money2);
		assertEquals("Result",1200,money1.getAmount());
	}

	@Test
	public void testMinus() {
		money1.minus(money2);
		assertEquals("Result",-200,money1.getAmount());
	}

	@Test
	public void testTimes() {
		money1.times(1);
		assertEquals("Result",500,money1.getAmount());
	}

	@Test
	public void testDividedBy() {
		money3.dividedBy(2);
		assertEquals("Result",5000,money3.getAmount());
	}

	@Test
	public void testNegate() {
		money3.negate();
		assertEquals("Result",-10000,money3.getAmount());
	}

}
