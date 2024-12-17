package ma.hshaimi.customerservice;

import ma.hshaimi.customerservice.config.CustomerConfigParams;
import ma.hshaimi.customerservice.entities.Customer;
import ma.hshaimi.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({CustomerConfigParams.class})
public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder()
							.name("hamza").email("hamza@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("yassmine").email("yassmine@gmail.com")
					.build());
			customerRepository.findAll().forEach(c->{
				System.out.println("------------------");
				System.out.println(c.getId());
				System.out.println(c.getName());
				System.out.println(c.getEmail());
				System.out.println("------------------");
			});
		};
	}

}
