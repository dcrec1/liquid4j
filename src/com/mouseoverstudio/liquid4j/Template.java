package com.mouseoverstudio.liquid4j;

import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Template {

	private Invocable invocable;
	private Object liquid;

	public Template(Object liquid, ScriptEngine engine) {
		this.liquid = liquid;
		this.invocable = (Invocable) engine;
	}

	public String render(Map map) {
		try {
			Object result;
			if (map != null) {
				Object hash = invocable.invokeFunction("to_hash", map);
				result = invocable.invokeMethod(liquid, "render", hash);
			} else {
				result = invocable.invokeMethod(liquid, "render");
			}
			return (String) result;
		} catch (ScriptException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("executing method render with following hash:");
			for (Object key : map.keySet()) {
				sb.append("\n" + key.toString() + " => " + map.get(key));
			}
			throw new RuntimeException(sb.toString());
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(
					"method render doest not exists for Liquid template");
		}
	}

	public String render() {
		return render(null);
	}
}
