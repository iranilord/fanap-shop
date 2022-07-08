package ir.fanap.fanapshoping.service;

import ir.fanap.fanapshoping.dto.ProductDTO;
import ir.fanap.fanapshoping.model.Product;
import ir.fanap.fanapshoping.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        if (productDTO.getId() != null)
            product = getProduct(String.valueOf(productDTO.getId()));

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return productRepository.save(product);
    }

    @Transactional
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Transactional
    public Product getProduct(String id) {
        Optional<Product> product = productRepository.findById(Long.parseLong(id));
        return product.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Find !"));
    }

    @Transactional
    public void deleteProduct(String id) {
        productRepository.deleteById(Long.parseLong(id));
    }
}
