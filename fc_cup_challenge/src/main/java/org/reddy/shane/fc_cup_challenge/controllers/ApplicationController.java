package org.reddy.shane.fc_cup_challenge.controllers;

import org.reddy.shane.fc_cup_challenge.models.Application;
import org.reddy.shane.fc_cup_challenge.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {

	@Autowired
	ApplicationRepository applicationRepository;
	
	@RequestMapping("/citiapplication")
	public String application(Model model) {
		
		model.addAttribute("citiapplications", applicationRepository.findAll());
		return "citiapplication";

	}
	
	@RequestMapping("/create")
	public String create(Model model) {
		
		return "create";
		
	}
	
	@RequestMapping("/save")
	public String save(@RequestParam String appName, @RequestParam String appDesc, @RequestParam int appID, 
			@RequestParam String appURL) {
	
		Application application = new Application();
		application.setAppName(appName);
		application.setAppDesc(appDesc);
		application.setAppID(appID);
		application.setAppURL(appURL);
		applicationRepository.save(application);	
		return "redirect:/show/" + application.getId();
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable String id, Model model) {
		
		model.addAttribute("citiapplication", applicationRepository.findOne(id));
		return "show";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String id) {
		
		Application application = applicationRepository.findOne(id);
		applicationRepository.delete(application);	
		return "redirect:/citiapplication";
		
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		
		model.addAttribute("citiapplication", applicationRepository.findOne(id));
		return "edit";
		
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam String id, @RequestParam String appName, @RequestParam String appDesc, 
			@RequestParam int appID, @RequestParam String appURL) {

		Application application = applicationRepository.findOne(id);
		application.setAppName(appName);
		application.setAppDesc(appDesc);
		application.setAppID(appID);
		application.setAppURL(appURL);
		applicationRepository.save(application);
		return "redirect:/show/" + application.getId();
	}
}