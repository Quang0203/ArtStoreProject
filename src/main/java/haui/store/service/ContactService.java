package haui.store.service;

import java.util.List;


import haui.store.model.ContactModel;
import haui.store.entity.Contact;

public interface ContactService {
	ContactModel createContact(ContactModel contactModel);

	List<Contact> getListContactPending();

	Contact getContactByContactId(Integer id);

	void approveContact(Integer id);

	void delete(Integer id);

	List<Contact> getListContactChecked();
	
	List<Contact> findAll();
}
