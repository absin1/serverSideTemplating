package utils;

import java.util.ArrayList;

public class NavBarUtils {

	private ArrayList<String> navbarlist = new ArrayList<>();

	public NavBarUtils() {
		super();
		navbarlist.add("Home");
		navbarlist.add("Profile");
		navbarlist.add("Link");
		navbarlist.add("Logout");
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getNavbarlist() {
		return navbarlist;
	}

	public void setNavbarlist(ArrayList<String> navbarlist) {
		this.navbarlist = navbarlist;
	}
	
	
	
	
}
