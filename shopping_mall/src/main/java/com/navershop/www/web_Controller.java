package com.navershop.www;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class web_Controller {
	
	PrintWriter pw = null;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/ajaxok3.do")
	public String ajaxok3(@RequestBody String arr, HttpServletResponse res) throws Exception{
		System.out.println(arr);
		JSONArray ja = new JSONArray(arr);
		System.out.println(ja.get(0));
		System.out.println(ja.get(1));
		JSONArray jaa1 = (JSONArray)ja.get(0);
		JSONArray jaa2 = (JSONArray)ja.get(1);
		for(int f=0; f<jaa1.length(); f++) {
			System.out.println(jaa1.get(f));
		}
		for(int ff=0; ff<jaa1.length(); ff++) {
			System.out.println(jaa2.get(ff));
		}
		
		this.pw = res.getWriter();
		this.pw.print("ok");
		
		return null;
	}
	
	//@RequestBody : JSON.stringify
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/ajaxok2.do")
	public String ajaxok2(@RequestBody String all_data, HttpServletResponse res) throws Exception{
		System.out.println(all_data);	//{"all_data":[]}
		JSONObject jo = new JSONObject(all_data);	//{}인식 시킨 후 key값으로 배열을 체크
		JSONArray ja = (JSONArray)jo.get("all_data");
		System.out.println(ja.get(0));
		
		//Front dataType이 JSON이므로, 결과값을 JSON으로 생성하여 회신 
		JSONObject result = new JSONObject();
		result.put("result", "ok");
		this.pw = res.getWriter();
		this.pw.print(result);
		
		return null;
	}
	
	//@RequestBody : GET/POST(X) JSON기반일 경우
	//@ResponseBody : 미디어타입, 파라미터타입 / *단, 인자값에는 미선언
	//@RequestParam : 배열을 이용하여 대표키로 전달 또는 대표키 없이 보조키로 전달 될 경우 사용할 수 있음
	//ajax통신 CORS 방식
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/ajaxok.do")
	public String ajaxok(@RequestParam(value = "all_data") List<String> alldata, 
			HttpServletResponse res) throws Exception{
		System.out.println(alldata);
		System.out.println(alldata.get(0));
		this.pw = res.getWriter();
		JSONObject jo = new JSONObject();
		jo.put("result", "ok");
		this.pw.print(jo);
		
		this.pw.close();
		return null;
	}
	
}
