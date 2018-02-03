/**
 * 
 */
package com.viksitpro.ui.component;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.GroupCourseMasteryStats;

/**
 * @author absin
 *
 */
@XmlRootElement
public class Chart extends Component {
	
	String restURL;
	String sql;
	String chartId;

	@XmlTransient
	ArrayList<ArrayList<String>> table;
	
	
	public ArrayList<ArrayList<String>> getTable() {
		return table;
	}

	public void setTable(ArrayList<ArrayList<String>> table) {
		this.table = table;
	}

	public String getChartId() {
		return chartId;
	}

	public void setChartId(String chartId) {
		this.chartId = chartId;
	}

	public String getRestURL() {
		return restURL;
	}

	public void setRestURL(String restURL) {
		this.restURL = restURL;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return getHtml();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.viksitpro.ui.component.Component#getHtml()
	 */
	@Override
	public String getHtml() {
		String name = Thread.currentThread().getName();
		long start = System.currentTimeMillis();
		System.out.println("Thread name " + name + " starting at " + start);

		this.setTable(new GroupCourseMasteryStats().runsql("select course_id, percentage_attendance,performance_percentage,course_completion,avg_feedback from group_course_mastery_stats where group_id = 5"));
		
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		/* add that list to a VelocityContext */
		VelocityContext context = new VelocityContext();
		context.put("chart", this);
		/* get the Template */
		Template t = ve.getTemplate("template_vms/CHART.vm");
		/* now render the template into a Writer */
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		/* use the output in your email body */
		long stop = System.currentTimeMillis();
		System.out.println("Thread name " + name + " stopping at " + stop + " after " + (stop - start));

		return writer.toString();
	}

}
