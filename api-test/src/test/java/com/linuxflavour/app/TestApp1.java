package com.linuxflavour.app;

import junit.framework.Assert;
import org.junit.Test;

public class TestApp1 {

	@Test
	public void testPrintHelloWorld() {

		Assert.assertEquals("Hello World", App.getHelloWorld());

	}

}

/*
package com.linuxflavour.app;

import junit.framework.Assert;
import org.junit.Test;

public class TestApp1 {

	@Test
	public void helloWorld() {
		Assert.assertEquals("Hello World", App.helloworld());
	}

}*/
