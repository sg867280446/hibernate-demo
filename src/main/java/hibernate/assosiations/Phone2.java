package hibernate.assosiations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "phone2")
public class Phone2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "number")
    private String number;

	public Phone2(String number) {
		this.number = number;
	}
	
	@ManyToOne
	private Person2 person;
	
	public Phone2(){};

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public Person2 getPerson() {
		return person;
	}

	public void setPerson(Person2 person) {
		this.person = person;
	}
	
	
	
	
}
