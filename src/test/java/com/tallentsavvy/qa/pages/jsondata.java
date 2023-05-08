package com.tallentsavvy.qa.pages;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

public class jsondata {
	
	@Test
	public  void jsonResource() throws IOException { 
		File jsonfile= new File("C:\\\\Users\\\\naras\\\\eclipse-workspace\\\\Com.Talentsavvy\\\\src\\\\main\\\\java\\\\com\\\\talentsavvy\\\\config\\\\data.json");
		Object data=JsonPath.read(jsonfile,"$."+"employee1");
		System.out.println(data);


	}

}
