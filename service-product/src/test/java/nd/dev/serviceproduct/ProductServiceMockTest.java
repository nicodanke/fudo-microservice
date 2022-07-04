package nd.dev.serviceproduct;

import nd.dev.serviceproduct.repository.ProductRepository;
import nd.dev.serviceproduct.service.ProductService;
import nd.dev.serviceproduct.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository repository;

    private ProductService service;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        service = new ProductServiceImpl(repository);

        Product pr1 = Product.builder()
                .id(1L)
                .name("test")
                .description("")
                .category(Category.builder().id(1L).name("test").build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();

        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.of(pr1));

        Mockito.when(repository.save(pr1))
                .thenReturn(pr1);
    }

    @Test
    public void whenValidGetId_thenReturnProduct(){
        Product found = service.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("test");
    }

    @Test
    public void whenValidUpdateStock_thenReturnNewStock(){
        Product newStock = service.updateStock(1L, Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }
}
