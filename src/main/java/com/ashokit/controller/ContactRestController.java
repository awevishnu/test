package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Contact;
import com.ashokit.service.ContactService;

@RestController
public class ContactRestController {
	
	@Autowired
	private ContactService conService;
	
	@PostMapping("/contact")
	ResponseEntity<String> contact (@RequestBody Contact contact)
	{
		String status=conService.upsert(contact);
		return new  ResponseEntity<>(status,HttpStatus.CREATED);
		
	}

	@GetMapping("/contacts")
	ResponseEntity<List<Contact>> getAllContacts( )
	{
		List<Contact> contactList=conService.getAllContacts();
		return new ResponseEntity<>(contactList,HttpStatus.OK);
	}

	@GetMapping("/contact/{cid}")
	ResponseEntity<Contact> getContact(@PathVariable int cid)
	{
		Contact contact=conService.getContact(cid);
		return new ResponseEntity<>(contact,HttpStatus.OK);
	}

	@DeleteMapping("/contact/{cid}")
	ResponseEntity<String> deleteContact(@PathVariable int cid){
		String deleteContact=conService.deleteContact(cid);
		return new ResponseEntity<>(deleteContact,HttpStatus.OK);
	}
}
