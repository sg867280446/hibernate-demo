package hibernate.assosiations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "phone")
public class Phone1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "number")
    private String number;

	public Phone1(String number) {
		this.number = number;
	}
	
	public Phone1(){};

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}
	
	
}
