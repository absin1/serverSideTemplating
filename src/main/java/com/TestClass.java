
package com;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class TestClass {

	public static void main(String[] args) throws Exception {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		/* organize our data */
		ArrayList list = new ArrayList();
		ArrayList map = new ArrayList();
		map.add("horse");
		map.add("00.00");
		list.add(map);

		map = new ArrayList();
		map.add("dog");
		map.add("9.99");
		list.add(map);
		map = new ArrayList();
		map.add("bear");
		map.add(".99");
		list.add(map);
		/* add that list to a VelocityContext */
		VelocityContext context = new VelocityContext();
		context.put("petList", list);
		/* get the Template */
		Template t = ve.getTemplate("template_vms/CHART.vm");
		/* now render the template into a Writer */
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		/* use the output in your email body */

		System.out.println((writer.toString()));
	}

}
