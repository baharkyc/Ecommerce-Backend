package com.workintech.fizzystore.service;

import com.workintech.fizzystore.entity.Order;
import com.workintech.fizzystore.entity.Product;
import com.workintech.fizzystore.exceptions.FizzyStoreException;
import com.workintech.fizzystore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService{

    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Product with id: " + id + " not found.", HttpStatus.NOT_FOUND));

        return product;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product productToUpdate = productRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Product with id: " + id + " not found.", HttpStatus.NOT_FOUND));

        if (product.getName() != null) {
            productToUpdate.setName(product.getName());
        }
        if (product.getDescription() != null) {
            productToUpdate.setDescription(product.getDescription());
        }
        if (product.getPrice() != null) {
            productToUpdate.setPrice(product.getPrice());
        }
        if (product.getStock() != null) {
            productToUpdate.setStock(product.getStock());
        }
        if (product.getReview() != null) {
            productToUpdate.setReview(product.getReview());
        }
        if (product.getCategoryId() != null) {
            productToUpdate.setCategoryId(product.getCategoryId());
        }
        if (product.getRating() != null) {
            productToUpdate.setRating(product.getRating());
        }
        if (product.getImage() != null) {
            productToUpdate.setImage(product.getImage());
        }
        if (product.getOrders() != null) {
            productToUpdate.setOrders(product.getOrders());
        }

        return productRepository.save(productToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Product with id: " + id + " not found.", HttpStatus.NOT_FOUND)
        );
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> sortByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Product> sortByPriceDesc() {
        return productRepository.findAllByOrderByPriceDesc();
    }
}
