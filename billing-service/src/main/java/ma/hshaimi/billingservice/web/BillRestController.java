package ma.hshaimi.billingservice.web;


import ma.hshaimi.billingservice.feign.ProductRestClient;
import ma.hshaimi.billingservice.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ma.hshaimi.billingservice.repository.ProductItemRepository;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductRestClient ProductItemRepository;



}
