package com.mouseoverstudio.liquid4j.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.mouseoverstudio.liquid4j.Liquid4j;

public class Liquid4jTest {

	@Test
	public void stringOutput() {
		String name = "Diego";
		Map map = new HashMap();
		map.put("name", name);
		assertEquals("hi " + name, Liquid4j.parse("hi {{name}}").render(map));
	}
	
	@Test
	public void filters() {
		Map map = new HashMap();
		map.put("now", new Date(12345678));
		System.out.println(Liquid4j.parse("Hello {{ now | date: '%Y %h' }}").render(map));
	}

}
