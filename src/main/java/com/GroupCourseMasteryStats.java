package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.viksitpro.ui.component.Chart;

/**
 * Servlet implementation class GroupCourseMasteryStats
 */
public class GroupCourseMasteryStats extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GroupCourseMasteryStats() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "select course_id, percentage_attendance,performance_percentage,course_completion,avg_feedback from group_course_mastery_stats where group_id = 5";
		if (request.getParameterMap().containsKey("sql")) {
			sql = request.getParameter("sql");
			System.out.println(sql);
		}
		if (request.getParameterMap().containsKey("tableHeaders")) {

		}
		//JsonArray runsql = runsql(sql);
		//response.getWriter().append(runsql.toString());
	}

	public ArrayList<ArrayList<String>> runsql(String sql) {
		System.out.println(sql);
		JsonArray array = new JsonArray();
		ArrayList<ArrayList<String>> tableBody = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://business.talentify.in:5432/business_setup",
					"postgres", "4a626021-e55a");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// Get column headers
			ResultSetMetaData rsmd = rs.getMetaData();
			ArrayList<String> tableHead = new ArrayList<>();
			int i = 0;
			for (i = 1; i <= rsmd.getColumnCount(); i++)
				tableHead.add(rsmd.getColumnName(i));
			tableBody.add(tableHead);
			// Get table body
			while (rs.next()) {
				ArrayList<String> tableRow = new ArrayList<>();
				for (int j = 1; j < i; j++) {
					tableRow.add(rs.getString(j));
				}
				tableBody.add(tableRow);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return tableBody;
	}
}
