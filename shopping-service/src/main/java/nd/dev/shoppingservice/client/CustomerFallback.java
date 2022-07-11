package nd.dev.shoppingservice.client;

import nd.dev.shoppingservice.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

public class CustomerFallback{

    public ResponseEntity<Customer> getCustomer(long id) {
        Customer customer = Customer.builder()
                .firstName("none")
                .lastName("none")
                .email("none")
                .photoUrl("none").build();
        return ResponseEntity.ok(customer);
    }
}
