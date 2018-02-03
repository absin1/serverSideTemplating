/**
 * 
 */
package com.viksitpro.ui.component;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author absin
 *
 */
@XmlRootElement
public class Chart extends Component {

	String restURL;
	String sql;
	String chartId;

	public String getChartId() {
		return chartId;
	}

	public void setChartId(String chartId) {
		this.chartId = chartId;
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
		// TODO Auto-generated method stub
		return getHtml();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.viksitpro.ui.component.Component#getHtml()
	 */
	@Override
	public String getHtml() {
		System.err.println("Fucking reached here");
		return null;
	}

}
