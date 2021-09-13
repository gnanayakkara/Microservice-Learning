package com.gnanayakkara.configconsumer.configconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnanayakkara.configconsumer.configconsumer.model.MemberProfileConfiguration;

//@RestController
@Controller
public class ProfileController {

	@Autowired
	MemberProfileConfiguration memberProfileConfiguration;
	
	/*@RequestMapping("/profile")
	public MemberProfileConfiguration getConfig() {
		return memberProfileConfiguration;
	}*/
	
	@RequestMapping("/profile")
	public String getConfig(Model model) {
		model.addAttribute("model", memberProfileConfiguration.getDefaultModel());
		model.addAttribute("min", memberProfileConfiguration.getMinRentPeriod());
		return "mprofile";
	}
}
