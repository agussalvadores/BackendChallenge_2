package com.init.rate.rest;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/")
public class Rate {
	@SuppressWarnings("deprecation")
	@GetMapping
	public String calculateRate() {
		JSONParser parser = new JSONParser();
		try {
            Object obj = parser.parse(new FileReader("parameters.json")); //read json file
            JSONObject jsonObject = (JSONObject) obj;
            Parameters parameters = new Gson().fromJson(jsonObject.toString(), Parameters.class);
    		double rate;
    		java.util.Date currentDate = new java.util.Date(); //Current system Date
    		switch(parameters.getBrand()) {
    		case "VISA":
    			rate= ((currentDate.getYear()-100) / (currentDate.getMonth()+1)) * 0.01;
    		break;
    		case "NARA":
    			rate= (currentDate.getDate() * 0.5)*0.01;
    		break;
    		case "AMEX":
    			rate= ((currentDate.getMonth()+1) * 0.1)*0.01;
    		break;
    		default:
    			return "This brand card not exist yet";
    		}
    		double value = rate * parameters.getAmount();
    		
    		Return rt = new Return(parameters.getBrand(), parameters.getAmount(), rate, value, value+parameters.getAmount()); //create return json
    		
    		return rt.toJson().toString();
		} catch (Exception e) {
			return "json error";
		}
	}
}
