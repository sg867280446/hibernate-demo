package hibernate.assosiations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "person")
public class Person1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Phone1> phones = new ArrayList<Phone1>();

	public List<Phone1> getPhones() {
		return phones;
	}
	    
}
