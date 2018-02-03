/**
 * 
 */
package com.viksitpro.ui.component;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

/**
 * @author absin
 *
 */
public class ComponentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 //createHTMLPageXML();
		System.err.println(ComponentManager.getInstance().createPage(1));
		// new ComponentTest().unparseXML();
		System.exit(0);
	}

	private void unparseXML() {
		ClassLoader cl = getClass().getClassLoader();
		File file = new File(cl.getResource("htmlPages.xml").getFile());
		System.out.println(file.getAbsolutePath());
		HTMLPageList html_pages = null;
		try {
			html_pages = (HTMLPageList) JAXBContext.newInstance(HTMLPageList.class).createUnmarshaller()
					.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		for (Object iterable_element : html_pages.getHtmlPages().get(0).getComponents()) {
			System.out.println();
		}
		System.out.println();
	}

	private static void createHTMLPageXML() {
		ArrayList<Component> componentList = new ArrayList<Component>();
		ArrayList<Component> componentList1 = new ArrayList<Component>();
		addCarouselTemplates(componentList);
		addChartTemplates(componentList1);
		HTMLPage page = new HTMLPage();
		page.setId(0);
		page.setComponents(componentList);
		HTMLPage page1 = new HTMLPage();
		page1.setId(1);
		page1.setComponents(componentList1);
		HTMLPageList p = new HTMLPageList();
		p.getHtmlPages().add(page);
		p.getHtmlPages().add(page1);
		JAXBContext context = null;
		Marshaller m = null;
		try {
			context = JAXBContext.newInstance(HTMLPageList.class);
			m = context.createMarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		try {
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		} catch (PropertyException e) {
			e.printStackTrace();
		}
		try {
			m.marshal(p, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static void addChartTemplates(ArrayList<Component> componentList) {
		Chart component1 = new Chart();
		component1.setTemplate("CHART");
		component1.setChartId("chart_div");
		component1.setSql("select * from dummy");

		Chart component2 = new Chart();
		component2.setTemplate("CHART");
		component2.setChartId("gg");;
		component2.setRestURL("http://rest-url.com");
		// component2.setType("URL");
		componentList.add(component1);
		componentList.add(component2);
	}

	private static void addCarouselTemplates(ArrayList<Component> componentList) {
		Carousel component1 = new Carousel();
		component1.setTemplate("CAROUSEL");
		component1.setId(1);
		component1.setSql("select * from dummy");

		Carousel component2 = new Carousel();
		component2.setTemplate("CAROUSEL");
		component2.setId(2);
		component2.setRestURL("http://rest-url.com");
		// component2.setType("URL");
		componentList.add(component1);
		componentList.add(component2);
	}

}
