package omar.lo.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import omar.lo.entities.Contact;

public interface IContact {

	public List<Contact> getContacts();
	//public Contact getContact(Long id);
	public Optional<Contact> getContact(Long id);
	public Page<Contact> chercher(String motCle, int page, int size);
	public Contact saveContact(Contact c);
	public boolean deleteContact(Long id);
}// IContact
