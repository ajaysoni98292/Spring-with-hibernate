package com.spring.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.example.persistence.model.Contact;
import com.spring.example.service.ContactService;

/**
 *
 * @author ajay
 */

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String listContacts(ModelMap contact) {
		contact.addAttribute("contact", new Contact());
		contact.addAttribute("contactList", contactService.findAll());
		return "contact";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact, BindingResult bindingResult) {
		contactService.create(contact);
		return "redirect:/contact";
	}

	@RequestMapping(value = "/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Long id) {
		contactService.deleteById(id);
		
		return "redirect:/contact";
	}

}