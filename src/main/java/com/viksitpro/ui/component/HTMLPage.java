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
public class HTMLPage {
	int id;
	ArrayList<Component> components;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name="component")
	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

}
