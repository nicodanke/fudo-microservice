package nd.dev.shoppingservice.model;
import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private double stock;
    private String status;
    private Date createdAt;
    private Category category;
}
