package com.aadil.phonebook.service;

import java.util.List;

import com.aadil.phonebook.model.ContactDtls;

public interface ContactService {
	
	public Boolean saveContactDtls(ContactDtls contacts);
	
	public List<ContactDtls> getAllContacts();
	
	public ContactDtls getContactById(Integer contactId);
	
	public Boolean updateContact(ContactDtls contacts);
	
	public Boolean deleteContactById(Integer contactId);

}
