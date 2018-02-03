package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class GetDashboardCards
 */
public class GetDashboardCards extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetDashboardCards() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "select category,image_url,course_description,course_name, id from course limit 10";
		if (request.getParameterMap().containsKey("sql")) {
			sql = request.getParameter("sql");
			System.out.println(sql);
		}
		JsonArray runsql = runsql(sql);
		response.getWriter().append(runsql.toString());
	}

	private JsonArray runsql(String sql) {
		JsonArray array = new JsonArray();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://business.talentify.in:5432/business_setup",
					"postgres", "4a626021-e55a");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// title subtitle image text buttonUrl
			while (rs.next()) {
				JsonObject jsonObject = new JsonObject();
				jsonObject.addProperty("title", rs.getString(1));
				jsonObject.addProperty("subtitle", rs.getString(4));
				jsonObject.addProperty("image", "http://cdn.talentify.in:9999" + rs.getString(2));
				jsonObject.addProperty("text", rs.getString(3));
				jsonObject.addProperty("buttonUrl",
						"http://business.talentify.in/edit_Course.jsp?course=" + rs.getString(5));
				array.add(jsonObject);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return array;
	}

}
