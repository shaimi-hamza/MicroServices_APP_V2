package ma.hshaimi.inventoryservice;

import ma.hshaimi.inventoryservice.entities.Products;
import ma.hshaimi.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Products.builder()
							.id(UUID.randomUUID().toString())
							.name("Computer")
							.price(3200)
							.quantity(11)
					.build());
			productRepository.save(Products.builder()
					.id(UUID.randomUUID().toString())
					.name("printer")
					.price(1000)
					.quantity(30)
					.build());
			productRepository.save(Products.builder()
					.id(UUID.randomUUID().toString())
					.name("Phone")
					.price(5000)
					.quantity(9)
					.build());
			productRepository.findAll().forEach(p ->{
						System.out.println(p.toString());
					}
					);
		};
	}

}
