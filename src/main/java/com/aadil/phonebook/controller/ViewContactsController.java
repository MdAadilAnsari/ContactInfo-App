package com.aadil.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aadil.phonebook.model.ContactDtls;
import com.aadil.phonebook.service.ContactService;

@Controller
public class ViewContactsController {

	@Autowired
	private ContactService contactService;

	@GetMapping(value = "/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		ContactDtls c = contactService.getContactById(contactId);
		model.addAttribute("contact", c);
		return "contactInfo";
	}

	@RequestMapping(value = "/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer contactId) {
		Boolean isDeleted = contactService.deleteContactById(contactId);
		if(isDeleted) {
			return "redirect:/viewContacts";
		}
		return null;
	}
}
