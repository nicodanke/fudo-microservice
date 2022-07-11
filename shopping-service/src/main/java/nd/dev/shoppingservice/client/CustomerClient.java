package nd.dev.shoppingservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import nd.dev.shoppingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping(value = "/customers/{id}")
    @CircuitBreaker(name = "customersCB", fallbackMethod = "getCustomerFallback")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);

    default ResponseEntity<Customer> getCustomerFallback(long id) {
        Customer customer = Customer.builder()
                .firstName("none")
                .lastName("none")
                .email("none")
                .photoUrl("none").build();
        return ResponseEntity.ok(customer);
    }
}
