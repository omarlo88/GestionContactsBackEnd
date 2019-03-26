package omar.lo.webService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import omar.lo.entities.Contact;
import omar.lo.metier.ContactImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/GestionDesContacts")
public class ContactRestController {

	@Autowired
	private ContactImpl contactImpl;
	
	@GetMapping("/contacts")
	public List<Contact> getContacts(){
		return contactImpl.getContacts();
	}// getContacts
	
	/*@GetMapping("/contacts/{id}")
	public Contact getContact( @PathVariable("id") Long id){
		return contactImpl.getContact(id);
	}// getContact */	
	
	@GetMapping("/contacts/{id}")
	public Optional<Contact> getContact( @PathVariable Long id){
		return contactImpl.getContact(id);
	}// getContact
	
	@GetMapping("/chercher")
	public Page<Contact> chercherContact( 
			@RequestParam(name="motCle", defaultValue="") String motCle, 
			@RequestParam(name="page", defaultValue="0") int page, 
			@RequestParam(name="size", defaultValue="5") int size){
		return contactImpl.chercher("%" + motCle + "%", page, size);
	}// chercherContact
	
	@PostMapping("/contacts")
	public Contact saveContact(@RequestBody @Valid Contact c) {
		return contactImpl.saveContact(c);
	}// saveContact
	
	@PutMapping("/contacts/{id}")
	public Contact updateContact(
			@PathVariable Long id,
			@RequestBody @Valid Contact c) {
		c.setId(id);
		return contactImpl.saveContact(c);
	}// saveContact
	
	@DeleteMapping("/contacts/{id}")
	public boolean deleteContact( @PathVariable Long id){
		contactImpl.deleteContact(id);
		return true;
	}// getContact
	
}// ContactRestController
