package example23.AttributeConverter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "person" )
public class Person {
	//主键id
	private Long id;
	//姓名
	private String name;
	//创建时间
	private Date creation_time;
	
	public Person(){}
	
	public Person(String name,Date date){
		this.name =  name;
		this.creation_time = date;
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getCreation_time() {
		return creation_time;
	}
	
	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}
	
	
}
