package com.automation.selenium.webtable.helper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTable {
	private WebElement tableElement;

	private WebTable(WebElement tableElement) {
		this.tableElement = tableElement;
	}

	public static WebTable getTable(WebElement tableElement) {
		return new WebTable(tableElement);
	}

	public WebElement getTableCaptionElement(String captionXpath) {
		return tableElement.findElement(By.xpath(captionXpath));
	}

	public String getTableCaptionText(String captionXpath) {
		return getTableCaptionElement(captionXpath).getText();
	}

	public WebTableRow getRow(int index, String rowXpath) {
		return new WebTableRow(getRowElement(index, rowXpath));
	}

	public WebElement getRowElement(int index, String rowXpath) {
		WebElement rowElement = (WebElement) tableElement.findElements(By.xpath(rowXpath)).get(index);
		return rowElement;
	}
	
	public List<WebTableRow> getRows(String rowXpath) {
		List<WebTableRow> rows = new ArrayList<WebTableRow>();
		for (WebElement webTableRowElement : tableElement.findElements(By.xpath(rowXpath))) {
			rows.add(new WebTableRow(webTableRowElement));
		}
		return rows;
	}
	
	public int getRowCount(String rowTagName) {
		return tableElement.findElements(By.tagName(rowTagName)).size();
	}

	public WebTablePart getTableHeader(String theadXpath) {
		return new WebTablePart(getTableHeaderElement(theadXpath));
	}

	public WebElement getTableHeaderElement(String theadXpath) {
		WebElement tableHeadElement = tableElement.findElement(By.xpath(theadXpath));
		return tableHeadElement;
	}

	public WebTablePart getTableFooter(String tfootXpath) {
		return new WebTablePart(getTableFooterElement(tfootXpath));
	}

	public WebElement getTableFooterElement(String tfootXpath) {
		WebElement tableFootElement = tableElement.findElement(By.xpath(tfootXpath));
		return tableFootElement;
	}

	public WebTablePart getTableBody(String tbodyXpath) {
		return new WebTablePart(getTableBodyElement(tbodyXpath));
	}

	public WebElement getTableBodyElement(String tbodyXpath) {
		WebElement tableBodyElement = tableElement.findElement(By.xpath(tbodyXpath));
		return tableBodyElement;
	}
}
