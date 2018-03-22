package com.wfs.automation.selenium.webtable.helper;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class WebTableCell {
	private WebElement cellElement;

	public WebTableCell(WebElement cellElement) {
		this.cellElement = cellElement;
	}

	public String getText() {
		return cellElement.getText();
	}

	public String getAttribute(String attribute) {
		return cellElement.getAttribute(attribute);
	}

	public Point getLocation() {
		return cellElement.getLocation();
	}

	public Dimension getSize() {
		return cellElement.getSize();
	}

	public boolean isDisplayed() {
		return cellElement.isDisplayed();
	}

	public boolean isEnabled() {
		return cellElement.isEnabled();
	}
	
	public WebElement getCell() {
		return cellElement;
	}
	public void setCell(WebElement cellElement) {
		this.cellElement = cellElement;
	}
}
