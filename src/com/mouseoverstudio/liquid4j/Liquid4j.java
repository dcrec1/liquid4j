package com.mouseoverstudio.liquid4j;

import static com.mouseoverstudio.mosju.Mosju.jruby;
import static com.mouseoverstudio.mosju.Mosju.readerOf;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import com.mouseoverstudio.rhyme.Rhyme;

public class Liquid4j {

	private static final String FUNCTION_NAME = "parse";

	private static CompiledScript compiledScript;
	private static ScriptEngine engine;

	static {
		engine = jruby();
		try {
			engine.eval(readerOf("com/mouseoverstudio/liquid4j/liquid4j.rb"));
			compiledScript = ((Compilable) engine)
					.compile(FUNCTION_NAME + "()");
			Rhyme.require("liquid");
		} catch (ScriptException e) {
			throw new RuntimeException(e);
		}
	}

	public static Template parse(String text) {
		final SimpleScriptContext context = new SimpleScriptContext();
		context.setAttribute("text", text, ScriptContext.ENGINE_SCOPE);
		try {
			return new Template(compiledScript.eval(context), engine);
		} catch (ScriptException e) {
			throw new RuntimeException(e);
		}
	}

}
