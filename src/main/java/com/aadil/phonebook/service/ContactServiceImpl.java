package com.aadil.phonebook.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aadil.phonebook.entity.ContactInfoEntity;
import com.aadil.phonebook.model.ContactDtls;
import com.aadil.phonebook.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public Boolean saveContactDtls(ContactDtls contacts) {
		ContactInfoEntity entity = new ContactInfoEntity();
		
		/*
		 * if(contacts.getContactId()!=null) { Optional<ContactInfoEntity> findById =
		 * contactRepo.findById(contacts.getContactId()); entity = findById.get(); }
		 */
		// Convert Model class into Entity class
		BeanUtils.copyProperties(contacts, entity);
		ContactInfoEntity savedEntity = contactRepo.save(entity);

		return savedEntity.getContactId() != null;
	}

	@Override
	public List<ContactDtls> getAllContacts() {
		List<ContactInfoEntity> entities = contactRepo.findAll();

		// Legacy Approach
		/*
		 * List<ContactDtls> contacts = new ArrayList<ContactDtls>();
		 * for(ContactInfoEntity entity : entities ) { ContactDtls contact = new
		 * ContactDtls(); BeanUtils.copyProperties(entity, contact);
		 * contacts.add(contact); }
		 */

		// Using Stream API
		List<ContactDtls> contacts = entities.stream().map(entity -> {
			ContactDtls contact = new ContactDtls();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());

		return contacts;
	}

	@Override
	public ContactDtls getContactById(Integer contactId) {
		Optional<ContactInfoEntity> findById = contactRepo.findById(contactId);
		if(findById.isPresent()) {
			ContactInfoEntity contactInfoEntity = findById.get();
			ContactDtls contacts = new ContactDtls();
			BeanUtils.copyProperties(contactInfoEntity, contacts);
			return contacts;
		}
		return null;
	}

	@Override
	public Boolean updateContact(ContactDtls contacts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteContactById(Integer contactId) {
		contactRepo.deleteById(contactId);
		return true;
	}

}
