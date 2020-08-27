package com.aadil.phonebook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aadil.phonebook.model.ContactDtls;
import com.aadil.phonebook.service.ContactService;

@Controller
public class ContactInfoController {

	private static final Logger logger = LoggerFactory.getLogger(ContactInfoController.class);
	@Autowired
	private ContactService contactService;

	/**
	 * This method is used to load ContactsDtls form
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = { "/", "/addContact" }, method = RequestMethod.GET)
	public String loadContactInfoForm(Model model) {
		ContactDtls contact = new ContactDtls();
		model.addAttribute("contact", contact);
		return "contactInfo";
	}         

	/**
	 * This method is used to handle ContactsDtls form submission
	 * 
	 * @param c
	 * @param attributes
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/saveContact",method = RequestMethod.POST)
	public String handleSubmitBtn(@ModelAttribute("contact") ContactDtls c, 
			RedirectAttributes attribute,
			Model model) {
		Boolean isSaved = contactService.saveContactDtls(c);
		logger.info("Contacts Dtls Form submited:: " + c);
		if (isSaved) {
			attribute.addFlashAttribute("successMsg", "Contact Saved Successfully");
		} else {
			attribute.addFlashAttribute("errMsg", "Failed To Save Contact!!");
		}
		return "redirect:/contactSavedSuccess" ;
	}

	
	@RequestMapping(value = "/contactSavedSuccess", method = RequestMethod.GET)
	public String contactSavedSuccess(Model model) {
		logger.info("contactSavedSuccess() method called..");
		model.addAttribute("contact", new ContactDtls());
		return "contactInfo";

	}
	 

	/**
	 * This method is used to get all ContactsDtls from Database
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/viewContacts",method = RequestMethod.GET)
	public String viewContacts(Model model) {
		List<ContactDtls> contact = contactService.getAllContacts();
		model.addAttribute("contacts", contact);
		return "viewContacts";
	}
}
