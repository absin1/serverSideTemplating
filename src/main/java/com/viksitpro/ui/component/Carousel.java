/**
 * 
 */
package com.viksitpro.ui.component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author absin
 *
 */
@XmlRootElement
public class Carousel extends Component {

	Integer id;
	String restURL;
	String sql;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

		ArrayList<HashMap<String, String>> responseData = getResponseData();
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		/* add that list to a VelocityContext */
		VelocityContext context = new VelocityContext();
		context.put("carousels", responseData);
		/* get the Template */
		Template t = ve.getTemplate("template_vms/CAROUSEL.vm");
		/* now render the template into a Writer */
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		/* use the output in your email body */
		long stop = System.currentTimeMillis();
		System.out.println("Thread name " + name + " stopping at " + stop + " after " + (stop - start));

		return writer.toString();
	}

	private ArrayList<HashMap<String, String>> getResponseData1() {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "horse");
		map.put("price", "00.00");
		list.add(map);

		map = new HashMap<String, String>();
		map.put("name", "dog");
		map.put("price", "9.99");
		list.add(map);
		map = new HashMap<String, String>();
		map.put("name", "bear");
		map.put("price", ".99");
		list.add(map);
		return list;
	}

	private ArrayList<HashMap<String, String>> getResponseData() {
		String response = "";
		try {
			response = sendGet(restURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonParser jsonParser = new JsonParser();
		JsonArray asJsonArray = jsonParser.parse(response).getAsJsonArray();
		ArrayList<HashMap<String, String>> responseArrasy = new ArrayList<>();
		for (JsonElement jsonElement : asJsonArray) {
			JsonObject asJsonObject = jsonElement.getAsJsonObject();
			HashMap<String, String> entry = new HashMap<>();
			for (String key : asJsonObject.keySet()) {
				entry.put(key, asJsonObject.get(key).getAsString());
			}
			responseArrasy.add(entry);
		}
		return responseArrasy;
	}

	public String sendGet(String restURL) throws Exception {
		String url = restURL;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		// con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-Encoding", "gzip");
		con.setConnectTimeout(100000000);
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
		// caseResult.setResponseBody(response.toString());
		return response.toString();

	}
}
