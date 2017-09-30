package com.linuxflavour.app;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

//public class AppTest {
public class GreeterTest {

	private Greeter greeter = new Greeter();

	@Test
	public void greeterSaysHello() {
		assertThat(greeter.sayHello(), containsString("Hello"));
	}

	@Test
	public void greeterSaysHello1() {
		assertThat(greeter.sayHello(), containsString("world"));
	}

}
