package com.example.MvcMysql;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.MvcMysql.Tbluser;



@Controller
public class MasterController {
	
	
	@Autowired
	private UserService userService;
	

	@RequestMapping("/")
	public String usermain(Model model) {
		List<Tbluser> listUsers = userService.listAll();
		model.addAttribute("listUsers", listUsers);
		return "user";
	}
	
//	@RequestMapping("/user")
//	public String user(Model model) {
//		List<Tbluser> listUsers = userService.listAll();
//		model.addAttribute("listUsers", listUsers);
//		return "user";
//	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteForm(@PathVariable(name = "id") int id) {
		userService.delete(id);
		return "userdeleted";
	}
	
	@RequestMapping(value = "/updateform/{id}", method = RequestMethod.GET)
    public String showEditTbluserPage(@PathVariable(name = "id") int id, Model model) {
		Tbluser tbluser = userService.get(id);
		model.addAttribute("tbluser", tbluser);
        return "updateform";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String SaveUser(@Valid Tbluser tbluser, BindingResult result, 
			ModelMap model, RedirectAttributes redirectattributes) {
		if (result.hasErrors()) {
			return "useradded";
		}
		userService.save(tbluser);
		return "useradd";
	}
	
	@RequestMapping(value = "/updateform/update", method = RequestMethod.POST)
	public String UpdateUser(@Valid Tbluser tbluser, BindingResult result, 
			ModelMap model, RedirectAttributes redirectattributes) {
		if (result.hasErrors()) {
			return "updateform";
		}
		userService.save(tbluser);
		return "userupdated";
	}
	
	@RequestMapping(value = "useradded", method = RequestMethod.GET)
	public String userform(ModelMap model) {
		Tbluser tbluser = new Tbluser();
		model.addAttribute("tbluser", tbluser);
		return "useradded";
	}
	

//	@ModelAttribute("brands")
//	public List<String> initializeSections() {
//
//		List<String> brands = new ArrayList<String>();
//		brands.add("PANASONIC");
//		brands.add("SAMSUNG");
//		brands.add("SANYO");
//		return brands;
//	}
}

