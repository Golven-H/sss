package springbootTest.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springbootTest.service.CxService;

@Controller
public class Test {
		
		@Autowired
		CxService test;
		
		@RequestMapping(value = "/hello")
		@ResponseBody
		public String hello() throws UnsupportedEncodingException {
			String test2 = test.test("450000", null, "桂AZ0106", "黄色");
			System.out.println(test2);
			return test2;
		}
	
}
