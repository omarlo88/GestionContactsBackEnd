package omar.lo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import omar.lo.entities.Contact;
import omar.lo.metier.ContactImpl;

@SpringBootApplication
public class GestionDesContactsApplication implements CommandLineRunner {

	@Autowired
	private ContactImpl contactImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionDesContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*contactImpl.saveContact(new Contact("Lo", "Omar", "omar@gmail.com", "08758899"));
		contactImpl.saveContact(new Contact("Loo", "OOmar", "lo@gmail.com", "0008758899"));*/
		/*contactImpl.getContacts().forEach(c ->{
			System.out.println(c);
		});*/
		contactImpl.getContacts().forEach(System.out::println);
	}
}
