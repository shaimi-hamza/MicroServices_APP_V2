package ma.hshaimi.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.hshaimi.billingservice.model.Customer;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billinDate;
    private long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems = new ArrayList<>();
    @Transient private Customer customer;

}
