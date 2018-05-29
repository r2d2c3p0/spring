package org.r2d2c3p0.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@RefreshScope
@RestController
public class ConfigController {
 
    // https://github.com/r2d2c3p0/spring/cloudconfig-repo
	@Value("${user: r2d2c3p0}")
    private String user;
 
    @RequestMapping("/default")
    @ResponseBody
    public String showUser() {
        return user;
    }
 
}
