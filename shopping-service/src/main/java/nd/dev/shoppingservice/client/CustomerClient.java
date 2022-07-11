package nd.dev.shoppingservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import nd.dev.shoppingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", fallback = CustomerFallback.class)
public interface CustomerClient {

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);
}
