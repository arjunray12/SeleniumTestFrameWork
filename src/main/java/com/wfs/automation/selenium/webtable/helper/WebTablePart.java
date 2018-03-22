package com.wfs.automation.selenium.webtable.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTablePart {
	private WebElement tablePartElement;

	public WebTablePart(WebElement tablePartElement) {
		this.tablePartElement = tablePartElement;
	}

	public WebTableRow getRow(int index, String trXpath) {
		return new WebTableRow(getRowElement(index, trXpath));
	}

	public WebElement getRowElement(int index, String trXpath) {
		WebElement rowElement = (WebElement) tablePartElement.findElements(By.xpath(trXpath)).get(index);
		return rowElement;
	}

	public int getRowCount(String trXpath) {
		return tablePartElement.findElements(By.xpath(trXpath)).size();
	}
}
