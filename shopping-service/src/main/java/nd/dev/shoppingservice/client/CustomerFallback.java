package nd.dev.shoppingservice.client;

import nd.dev.shoppingservice.model.Customer;
import org.springframework.http.ResponseEntity;

public class CustomerFallback implements CustomerClient{

    @Override
    public ResponseEntity<Customer> getCustomer(long id) {
        Customer customer = Customer.builder()
                .firstName("none")
                .lastName("none")
                .email("none")
                .photoUrl("none").build();
        return ResponseEntity.ok(customer);
    }
}
