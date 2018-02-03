/**
 * 
 */
package com.viksitpro.ui.component;

import java.util.concurrent.Callable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author absin
 *
 */
@XmlTransient
@XmlSeeAlso({ Carousel.class, Chart.class })
public abstract class Component implements Callable<String> {

	String template;

	@XmlAttribute(name = "template")
	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public abstract String getHtml();

}
