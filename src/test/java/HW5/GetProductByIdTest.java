package HW5;

import com.github.javafaker.Faker;
import HW5.api.ProductService;
import HW5.dto.Product;
import HW5.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;


public class GetProductByIdTest {

    static ProductService productService;
    Product product = null;
    Faker faker = new Faker();
    int id;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 500));
    }

    @Test
    void getProductByIdTest() throws IOException {
        Response<Product> response = productService.getProductById(id)
                .execute();
        id =  response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }
}
