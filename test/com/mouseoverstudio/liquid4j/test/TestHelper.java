package com.mouseoverstudio.liquid4j.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import resources.Product;

public class TestHelper {
	
	public static Collection products() {
		String description = "IS ked you word on eaceint. I dire nobbed lived o"
				+ "f to murd; he ine on herring al re my I wertablat b"
				+ "ebte, look mand me and ano the by comed my; I she of blin "
				+ "henot ocume, hety clegs. The on ead Joe lo"
				+ "ky of to-day, Joe aw oned to to I whip be thichal myselde"
				+ "got fords of so mand the of youts, was la";
		List<Product> products = new ArrayList<Product>();
		for (int i = 0; i < 3; i++) {
			products.add(new Product("Product " + (i + 1), i + 2.37,
					"Category " + (3 - i), description));
		}
		return products;
	}

}
