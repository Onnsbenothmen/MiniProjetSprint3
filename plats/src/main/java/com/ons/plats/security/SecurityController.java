package com.ons.plats.security;

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.GetMapping;

	@Controller
	public class SecurityController {
		@GetMapping("/accessdenied")
		public String error()
		{
		return "accessdenied";
		}
		@GetMapping("/login")
	    public String login()
	    {
	        return "login";
	    }
	}


