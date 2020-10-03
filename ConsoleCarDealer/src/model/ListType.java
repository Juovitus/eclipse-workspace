package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class ListType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="MAKE")
	private String make;
	@Column(name="TYPE")
	private String type;
	
	public ListType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ListType(String make, String type) {
		super();
		this.make = make;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getType() {
		return type;
	}

	public void setType(String item) {
		this.type = item;
	}
	public String returnTypeDetails( ) {
		return make + ": " + type;
	}

}
