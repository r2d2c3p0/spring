package org.reddy.shane.fc_cup_challenge.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "application")
public class Application {
	
	@Id
	String id;
	String appName;
	String appDesc;
	int appID;
	String appURL;
	
	public Application() {
	}
	
	public Application(String appName, String appDesc, int appID, String appURL) {
		this.appName = appName;
		this.appDesc = appDesc;
		this.appID = appID;
		this.appURL = appURL;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAppName() {
		return appName;
	}
	
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	public String getAppDesc() {
		return appDesc;
	}
	
	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}
	
	public int getAppID() {
		return appID;
	}
	
	public void setAppID(int appID) {
		this.appID = appID;
	}
	
	public String getAppURL() {
		return appURL;
	}
	
	public void setAppURL(String appURL) {
		this.appURL = appURL;
	}
    
}