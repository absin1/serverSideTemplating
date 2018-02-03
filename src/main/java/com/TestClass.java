
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

import com.viksitpro.ui.component.Chart;

public class TestClass {

	public static void main(String[] args) throws Exception {
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("one");
		list1.add("two");
		list1.add("three");
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("A");
		list2.add("B");
		list2.add("C");
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		list.add(list1);
		list.add(list2);
		Chart chart = new Chart();
		chart.setChartId("asasa");
		chart.setTable(list);
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		/* add that list to a VelocityContext */
		VelocityContext context = new VelocityContext();
		context.put("chart", chart);
		/* get the Template */
		Template t = ve.getTemplate("template_vms/LIST.vm");
		/* now render the template into a Writer */
		StringWriter writer = new StringWriter();
		t.merge(context, writer);

		System.out.println((writer.toString()));
	}

}
