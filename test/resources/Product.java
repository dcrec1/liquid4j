package resources;

import java.util.HashMap;
import java.util.Map;

import com.mouseoverstudio.rhyme.Rhyme;

public class Product {

	private String name;
	private double price;
	private String category;
	private String description;

	public Product(String name, double price, String category,
			String description) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
	}

	public Object to_liquid() {
		Map map = new HashMap();
		map.put("name", name);
		map.put("price", price);
		map.put("category", category);
		map.put("description", description);
		return Rhyme.translate(map);
	}

}
