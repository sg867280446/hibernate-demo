package hibernate.assosiations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "person2")
public class Person2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy="person")
	private List<Phone2> phones = new ArrayList<Phone2>();

	public List<Phone2> getPhones() {
		return phones;
	}
	
	public void addPhone(Phone2 phone) {
		phones.add( phone );
		phone.setPerson( this );
	}
	
	public void removePhone(Phone2 phone) {
		phones.remove( phone );
		phone.setPerson( null );
	}
    
}
