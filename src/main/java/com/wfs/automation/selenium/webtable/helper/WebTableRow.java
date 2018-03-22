package com.wfs.automation.selenium.webtable.helper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTableRow {
	private WebElement rowElement;

	public WebTableRow(WebElement rowElement) {
		this.rowElement = rowElement;
	}

	public WebTableCell getCell(int index, String tdXpath) {
		return new WebTableCell(getCellElement(index, tdXpath));
	}

	public WebElement getCellElement(int index, String tdXpath) {
		WebElement cellElement = (WebElement) rowElement.findElements(By.xpath(tdXpath)).get(index);
		return cellElement;
	}
	
	public int getCoulmnCount(String tdXpath) {
		return rowElement.findElements(By.xpath(tdXpath)).size();
	}

	public List<WebTableCell> getCoulmns(String columnXpath){
		List<WebTableCell> columns = new ArrayList<WebTableCell>();
		for (WebElement webTableColumnElement : rowElement.findElements(By.xpath(columnXpath))) {
			columns.add(new WebTableCell(webTableColumnElement));
		}
		return columns;
	}
	
	public int getHeaderCoulmnCount(String thXpath) {
		return rowElement.findElements(By.xpath(thXpath)).size();
	}

	public WebTableCell getHeaderCell(int index, String thXpath) {
		return new WebTableCell(getHeaderCellElement(index, thXpath));
	}

	public WebElement getHeaderCellElement(int index, String thXpath) {
		WebElement cellElement = (WebElement) rowElement.findElements(By.xpath(thXpath)).get(index);
		return cellElement;
	}
	public WebElement getRowElement(){
		return rowElement;
	}
	public void setRowElement(WebElement rowElement){
		this.rowElement = rowElement;
	}
}
