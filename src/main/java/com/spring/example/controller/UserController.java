package com.spring.example.controller;

import com.spring.example.model.ChangePassword;
import com.spring.example.model.Records;
import com.spring.example.persistence.model.Role;
import com.spring.example.persistence.model.User;
import com.spring.example.service.RoleService;
import com.spring.example.service.UserService;
import com.spring.example.utils.ActiveUserUtil;
import com.spring.example.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author ajay
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	ReloadableResourceBundleMessageSource messageSource;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(ModelMap users) {
		return "viewUser";
	}
	
	@RequestMapping(value = "/list/view", method = RequestMethod.GET)
	public @ResponseBody
	Records listPaginatedUsers(@RequestParam("startIndex") int startIndex ,
													   @RequestParam("numberOfRecordsToFetch") int numberOfRecordsToFetch) {
		return userService.listPaginatedUsers(startIndex, numberOfRecordsToFetch);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createUser(ModelMap users) {
		/*Added condition because when there is error in data while post request in createUser()
		* we added the user object received in createUser() bindingResult.hasErrors() 
		* and redirected to this method and it was overriding that attribute so error messages were 
		* not displayed on jsp page.
		*/
		if (!users.containsAttribute("user")) {
			users.addAttribute("user", new User());
		}
		users.addAttribute("role", new Role());
		Map<String,String> roleMap = roleService.getAllRole();
		users.addAttribute("roleMap", roleMap);
		return "createUser";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String redirectCreateUserPage(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
										 RedirectAttributes redirectAttributes,Locale locale) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
			redirectAttributes.addFlashAttribute("errorMessage", messageSource.getMessage("user.already.exist", null, null));
			redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/user/create";
        }
		user = userService.setUserAccountAccessControl(user);
		user.setEmail(user.getEmail().trim());
		user.setFirstName(user.getFirstName().trim());
		user.setLastName(user.getLastName().trim());
		user.setCreatedOn(DateUtils.getCurrentTime());
		userService.create(user);
		redirectAttributes.addFlashAttribute("successMessage", messageSource.getMessage("user.added.successfully", null,locale));
		return "redirect:/user/create";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody String deleteUser(@RequestParam("id") long id,ModelMap users) {
		userService.deleteById(id);
		return String.valueOf(userService.findRecordsCount());
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") long id,ModelMap user) {
		user.addAttribute("user", userService.findOne(id));
		return "editUser";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser() {
		return "redirect:/user/contact";
	}

	@RequestMapping(value = "/change-password", method = RequestMethod.GET)
	public String changePassword(ModelMap changePassword) {

		/*Added condition because when there is error in data while post request in changePassword()
		* we added the user object received in changePassword() bindingResult.hasErrors()
		* and redirected to this method and it was overriding that attribute so error messages were
		* not displayed on jsp page.
		*/
		if (!changePassword.containsAttribute("changePassword")) {
			changePassword.addAttribute("changePassword", new ChangePassword());
		}
		return "changePassword";
	}
	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public String redirectChangePassword(@Valid @ModelAttribute("changePassword") ChangePassword changePassword,
										 BindingResult bindingResult,RedirectAttributes redirectAttributes,Principal principal) {

		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.changePassword", bindingResult);
			redirectAttributes.addFlashAttribute("errorMessage", messageSource.getMessage("password.change.is.unsuccessful", null, null));
			redirectAttributes.addFlashAttribute("changePassword", changePassword);
			return "redirect:/user/change-password";
		}

		String message = userService.updatePassword(changePassword,ActiveUserUtil.getUser());
		if (message.equals(messageSource.getMessage("password.changed.successfully", null, null))) {
			redirectAttributes.addFlashAttribute("successMessage", messageSource.getMessage("password.changed.successfully", null, null));
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", messageSource.getMessage("old.password.is.incorrect", null, null));
		}
		return "redirect:/user/change-password";
	}

}
