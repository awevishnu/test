package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.Contact;

public interface ContactService {
	
	String upsert(Contact contact);

	List<Contact> getAllContacts();

	Contact getContact(int cid);

	String deleteContact(int cid);
}
