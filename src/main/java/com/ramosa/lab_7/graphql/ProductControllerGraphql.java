package com.ramosa.lab_7.graphql;

import com.ramosa.lab_7.Product;
import com.ramosa.lab_7.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ProductControllerGraphql {

    private final ProductService productService;

    public ProductControllerGraphql(ProductService productService) {
        this.productService = productService;
    }
    
    @QueryMapping
    public List<Product> allProducts() {
        return productService.getAllProducts();
    }

    @QueryMapping
    public Product productById(@Argument Long id) {
        return productService.getProductById(id);
    }

    @MutationMapping
    public Product addProduct(@Argument Map<String, Object> product) {
        String name = (String) product.get("name");
        
        Double price = ((Number) product.get("price")).doubleValue();

        Product newProduct = new Product(null, name, price);
        return productService.addProduct(newProduct);
    }
    
    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument Map<String, Object> product) {
        String name = (String) product.get("name");
        Double price = ((Number) product.get("price")).doubleValue();

        Product updatedDetails = new Product(null, name, price);
        return productService.updateProduct(id, updatedDetails);
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        
        Product product = productService.getProductById(id);
        if (product != null) {
            productService.deleteProduct(id);
            return true;
        }
        return false;
    }
}
