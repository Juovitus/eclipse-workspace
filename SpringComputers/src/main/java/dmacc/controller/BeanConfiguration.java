package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Address;
import dmacc.beans.Computer;

@Configuration
public class BeanConfiguration {
	@Bean
	public Computer computer() {
		Computer bean = new Computer();
		bean.setManufacturer("AMD");
		bean.setPhone("555-555-5555");
		bean.setPart("GPU");
		return bean;
	}
	
	@Bean
	public Address address() {
		Address bean = new Address("123 Main Street", "Des Moines", "IA");
		return bean;
	}
}
