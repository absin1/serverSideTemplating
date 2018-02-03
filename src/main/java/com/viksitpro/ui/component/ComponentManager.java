/**
 * 
 */
package com.viksitpro.ui.component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * @author absin
 * 
 *         A singleton which acts as the manager class for callable. This class
 *         distributes the workload into many parts. In our context the workload
 *         is creation of a lot
 */
public class ComponentManager {
	private static final ComponentManager instance = new ComponentManager();

	// private constructor to avoid client applications to use constructor
	private ComponentManager() {
	}

	public static ComponentManager getInstance() {
		return instance;
	}

	/**
	 * This method divides calls the rendering method for each component in
	 * parallel.
	 * 
	 * Every HTML page has some components. Essentially we are trying to to
	 * fasten the process of HTML generation for each component and using
	 * callable, meaning every component HTML will be rendered in parallel.
	 * 
	 * @param pageID
	 * @return
	 */
	public String createPage(int pageID) {
		HTMLPage htmlPage = getHTMLPage(pageID);
		int size = htmlPage.getComponents().size();
		ExecutorService executorService = Executors.newFixedThreadPool(size);
		List<Future<String>> list = new ArrayList<Future<String>>();
		for (Component component : htmlPage.getComponents()) {
			Future<String> future = executorService.submit(component);
			list.add(future);
		}
		String html = "";
		long start = System.currentTimeMillis();
		System.out.println("Threads starting at " + start);

		for (Future<String> future : list) {
			try {
				html += future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		long stop = System.currentTimeMillis();
		System.out.println("Threads stopping at " + stop + " after " + (stop - start));
		return html;
	}

	/**
	 * Returns HTMLPage instance for an id. The HTMLPage object gets
	 * unserialized from an XML. These XMLs are stored in the
	 * /src/main/resources/HTMLPages folder.
	 * 
	 * @param pageID
	 * @return
	 */
	private HTMLPage getHTMLPage(int pageID) {
		ClassLoader cl = getClass().getClassLoader();
		File f = new File(cl.getResource("htmlPages.xml").getPath());
		HTMLPageList html_pages = null;
		try {
			html_pages = (HTMLPageList) JAXBContext.newInstance(HTMLPageList.class).createUnmarshaller().unmarshal(f);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		for (HTMLPage htmlPage : html_pages.getHtmlPages()) {
			if (htmlPage.getId() == pageID)
				return htmlPage;
		}
		return null;
	}
}
