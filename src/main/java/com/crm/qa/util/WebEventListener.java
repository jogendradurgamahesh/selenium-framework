package com.crm.qa.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

//public class WebEventListener extends TestBase implements WebDriverListener{
public class WebEventListener implements WebDriverListener {

	 @Override
	    public void beforeGet(WebDriver driver, String url) {
	        System.out.println("Before navigating to: " + url);
	    }

	    @Override
	    public void afterGet(WebDriver driver, String url) {
	        System.out.println("Navigated to: " + url);
	    }

	    // ================= FIND ELEMENT =================

	    @Override
	    public void beforeFindElement(WebDriver driver, By locator) {
	        System.out.println("Trying to find Element By : " + locator);
	    }

	    @Override
	    public void afterFindElement(WebDriver driver, By locator, WebElement element) {
	        System.out.println("Found Element By : " + locator);
	    }

	    // ================= CLICK =================

	    @Override
	    public void beforeClick(WebElement element) {
	        System.out.println("Trying to click on: " + element);
	    }

	    @Override
	    public void afterClick(WebElement element) {
	        System.out.println("Clicked on: " + element);
	    }

	    // ================= SEND KEYS =================

	    @Override
	    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
	        System.out.println("Typing into: " + element);
	    }

	    @Override
	    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
	        System.out.println("Typed into: " + element);
	    }

	    // ================= EXCEPTION =================

	    @Override
	    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
	        System.out.println("Exception Occurred: " + e.getMessage());
	    }
}
