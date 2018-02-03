/**
 * 
 */
package com.viksitpro.ui.component;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author absin
 *
 */
public class ComponentRepository {
	private ArrayList<Component> componentList;

	@XmlElement(name = "component")
	public ArrayList<Component> getComponentList() {
		return componentList;
	}

	public void setComponentList(ArrayList<Component> componentList) {
		this.componentList = componentList;
	}
}
