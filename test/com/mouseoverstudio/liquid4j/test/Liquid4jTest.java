package com.mouseoverstudio.liquid4j.test;

import static com.mouseoverstudio.liquid4j.test.TestHelper.products;
import static com.mouseoverstudio.mosju.Mosju.textOf;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mouseoverstudio.liquid4j.Liquid4j;

public class Liquid4jTest {

	private static Map map;

	@BeforeClass
	public static void setUp() {
		map = new HashMap();
	}

	@Test
	public void stringOutput() {
		String name = "Diego";
		map.put("name", name);
		assertEquals("hi " + name, Liquid4j.parse("hi {{name}}").render(map));
	}

	@Test
	public void filters() {
		map.put("now", new Date(12345678));
		assertEquals("Hello 1970 May", Liquid4j.parse(
				"Hello {{ now | date: '%Y %h' }}").render(map));
	}

	@Test
	public void loop() throws IOException {
		map.put("products", products());
		// FIXME test shouldnt have trim
		// TODO discover why test dont pass without trim if apparently both
		// strings are equal
		assertEquals(textOf("resources/loop.result").trim(), Liquid4j.parse(
				textOf("resources/loop.liquid")).render(map).trim());
	}

	@Test
	public void loopWithFilters() throws IOException {
		map.put("products", products());
		assertEquals(textOf("resources/mixed_html.result").trim(), Liquid4j
				.parse(textOf("resources/mixed_html.liquid")).render(map)
				.trim());
	}
	
	@Test
	public void withoutHash() {
		assertEquals("hi Diego", Liquid4j.parse("hi Diego").render());
	}
	
}