package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	@Test (groups = "Smoke")
	public void productAvailabilityTest() 
	{ indexpage=new IndexPage();
		searchresultpage=indexpage.searchProdct("T-shirt");
		boolean validate = searchresultpage.isProductAvailable();
	    Assert.assertTrue(validate);
	
	
	}

}
