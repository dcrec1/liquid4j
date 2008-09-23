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
			Object hash = null;
			if (map != null) {
				hash = invocable.invokeFunction("to_hash", map);
			}
			return (String) invocable.invokeFunction("render", liquid, hash);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String render() {
		return render(null);
	}
}
