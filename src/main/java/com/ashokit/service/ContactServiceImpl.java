package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Contact;
import com.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;
	

	@Override
	public String upsert(Contact contact) {
		Contact cn=contactRepo.save(contact);
		return "SUCCESS";
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepo.findAll();
	}

	@Override
	public Contact getContact(int cid) {
	Optional<Contact> findById=contactRepo.findById(cid);
	if(findById.isPresent())
	{
	return findById.get();
	}
	else
		return null;
	}

	@Override
	public String deleteContact(int cid) {
		contactRepo.deleteById(cid);
		return "SUCCESS";
	}

}
