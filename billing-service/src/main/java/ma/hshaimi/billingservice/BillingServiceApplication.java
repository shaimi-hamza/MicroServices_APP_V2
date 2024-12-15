package ma.hshaimi.billingservice;

import ma.hshaimi.billingservice.entities.Bill;
import ma.hshaimi.billingservice.entities.ProductItem;
import ma.hshaimi.billingservice.feign.CustomerRestClient;
import ma.hshaimi.billingservice.feign.ProductRestClient;
import ma.hshaimi.billingservice.model.Customer;
import ma.hshaimi.billingservice.model.Product;
import ma.hshaimi.billingservice.repository.BillRepository;
import ma.hshaimi.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository,
										ProductItemRepository productItemRepository,
										CustomerRestClient customerRestClient,
										ProductRestClient productRestClient) {
		return args -> {
		Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
		Collection<Product> products = productRestClient.getAllProducts().getContent();

		customers.forEach(customer -> {
			Bill bill = Bill.builder()
					.billinDate(new Date())
					.customerId(customer.getId())
					.build();
			billRepository.save(bill);
			products.forEach(product -> {
				ProductItem productItem=ProductItem.builder()
						.bill(bill)
						.productId(product.getId())
						.quantity(1+new Random().nextInt(100))
						.unitPrice(product.getPrice())
						.build();
				productItemRepository.save(productItem);
			});
		});
		};
	}
}