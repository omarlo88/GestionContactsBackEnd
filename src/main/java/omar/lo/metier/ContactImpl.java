package omar.lo.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import omar.lo.dao.ContactRepository;
import omar.lo.entities.Contact;

@Service
@Transactional
public class ContactImpl implements IContact {
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<Contact> getContacts() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}

	/*@Override
	public Contact getContact(Long id) {
		// TODO Auto-generated method stub
		return contactRepository.getOne(id);
	}*/
	
	@Override
	public Optional<Contact> getContact(Long id) {
		// TODO Auto-generated method stub
		return contactRepository.findById(id);
	}

	@Override
	public Page<Contact> chercher(String motCle, int page, int size) {
		// TODO Auto-generated method stub
		return contactRepository.chercher(motCle, PageRequest.of(page, size));
	}

	@Override
	public Contact saveContact(Contact c) {
		// TODO Auto-generated method stub
		return contactRepository.save(c);
	}

	@Override
	public boolean deleteContact(Long id) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(id);
		return true;
	}

}
