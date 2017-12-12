package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

public class RetirementTest {

	@Test
	public void testRetirement() {
		Retirement r = new Retirement(40,7,20,2.5,10000,2642);
		assertEquals(r.TotalAmountSaved(),1388556.3,0.001);
		assertEquals(r.AmountToSave(r.TotalAmountSaved()),529.01,0.001);
	}

}
