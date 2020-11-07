package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
public class Computer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String manufacturer;
	private String phone;
	private String part;
	@Autowired
	private Address address;
	
//	public Computer() {
//		super();
//		this.part = "CPU";
//	}
//	
//	public Computer(String name) {
//		
//	}
//	
//	public Computer(String manufacturer, String phone, String part) {
//		
//	}
//	
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getManufacturer() {
//		return manufacturer;
//	}
//
//	public void setManufacturer(String manufacturer) {
//		this.manufacturer = manufacturer;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getPart() {
//		return part;
//	}
//
//	public void setPart(String part) {
//		this.part = part;
//	}
//
//	public Computer(int id, String manufacturer, String phone, String part) {
//		
//	}
//	
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//
//	@Override
//	public String toString() {
//		return "Contact [id = " + id + ", manufacturer=" + manufacturer + ", phone=" + phone + ", part=" + part + ", address=" + address + "]";
//	}
}
