package ma.hshaimi.inventoryservice.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @Setter @Getter @Builder @ToString

public class Produits {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}
