/**
 * 
 */
package com.viksitpro.ui.component;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author absin
 *
 */
@XmlRootElement
public class HTMLPageList {
	ArrayList<HTMLPage> htmlPages = new ArrayList<>();

	@XmlElement(name="page")
	public ArrayList<HTMLPage> getHtmlPages() {
		return htmlPages;
	}

	public void setHtmlPages(ArrayList<HTMLPage> htmlPages) {
		this.htmlPages = htmlPages;
	}

}
