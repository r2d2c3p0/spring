package org.r2d2c3p0.pas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	private static final String RESPONSE = "Hello from Shane's PCF PAS container!";

    @RequestMapping(value = {"/**/*","/"}, method = RequestMethod.GET)
    @ResponseBody
    public String ContainerHello(){
        return RESPONSE;
    }

}
