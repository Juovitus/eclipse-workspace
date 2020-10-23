package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Address;
import dmacc.beans.Computer;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.ContactRepository;

@SpringBootApplication
public class SpringComputersApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringComputersApplication.class, args);
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		Computer c = appContext.getBean("computer", Computer.class);
		System.out.println(c.toString());
	}	
	
	@Autowired
	ContactRepository repo;

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		Computer c = appContext.getBean("computer", Computer.class);
		c.setPart("MOBO");
		repo.save(c);
		Computer d = new Computer("Intel", "555-555-5557", "RAM");
		Address a = new Address("123 Main Street", "Des Moines", "IA");
		d.setAddress(a);
		repo.save(d);
		List<Computer> allMyComputers = repo.findAll();
		for(Computer comp: allMyComputers) {
			System.out.println(comp.toString());
		}
		((AbstractApplicationContext) appContext).close();
	}
}
