package com.workintech.fizzystore.service;

import com.workintech.fizzystore.entity.Product;
import com.workintech.fizzystore.exceptions.FizzyStoreException;
import com.workintech.fizzystore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public List<Product> getProducts(Long categoryId, String sort) {

        // No pagination, returns List<Product>
        if (categoryId != null && sort != null) {
            return getSortedAndFiltered(categoryId, sort);
        } else if (categoryId != null) {
            return productRepository.findByCategoryId(categoryId);
        } else if (sort != null) {
            return sortByPrice(sort);
        } else {
            return productRepository.findAll();
        }
    }


    @Override
    public Page<Product> getProducts(Long categoryId, String sort, Pageable pageable) {

        // Pagination, returns Page<Product> dön
        if (categoryId != null && sort != null) {
            return getSortedAndFilteredPageable(categoryId, sort, pageable);
        } else if (categoryId != null) {
            return productRepository.findByCategoryId(categoryId, pageable);
        } else if (sort != null) {
            return sortByPricePageable(sort, pageable);
        } else {
            return productRepository.findAll(pageable);
        }
    }


    private List<Product> sortByPrice(String sort) {

        String[] parts = sort.split(":");
        String field = parts[0];
        String direction = parts.length > 1 ? parts[1] : "asc";

        return switch (field.toLowerCase()) {
            case "price" -> "desc".equalsIgnoreCase(direction)
                    ? productRepository.findAllByOrderByPriceDesc()
                    : productRepository.findAllByOrderByPriceAsc();
            case "rating" -> "desc".equalsIgnoreCase(direction)
                    ? productRepository.findAllByOrderByRatingDesc()
                    : productRepository.findAllByOrderByRatingAsc();
            default -> productRepository.findAll();
        };
    }

    private Page<Product> sortByPricePageable(String sort, Pageable pageable) {

        String[] parts = sort.split(":");
        String field = parts[0];
        String direction = parts.length > 1 ? parts[1] : "asc";

        return switch (field.toLowerCase()) {
            case "price" -> "desc".equalsIgnoreCase(direction)
                    ? productRepository.findAllByOrderByPriceDesc(pageable)
                    : productRepository.findAllByOrderByPriceAsc(pageable);
            case "rating" -> "desc".equalsIgnoreCase(direction)
                    ? productRepository.findAllByOrderByRatingDesc(pageable)
                    : productRepository.findAllByOrderByRatingAsc(pageable);
            default -> productRepository.findAll(pageable);
        };
    }

    private List<Product> getSortedAndFiltered(Long categoryId, String sort) {
        //shop/:categoryId
        //products?sort=price:desc

        String[] parts = sort.split(":");
        String field = parts[0];
        String direction = parts.length > 1 ? parts[1] : "asc";

        return switch (field.toLowerCase()) {

            case "price" -> "desc".equalsIgnoreCase(direction)

                    ? productRepository.findByCategoryIdOrderByPriceDesc(categoryId)
                    : productRepository.findByCategoryIdOrderByPriceAsc(categoryId);

            case "rating" -> "desc".equalsIgnoreCase(direction)

                    ? productRepository.findByCategoryIdOrderByRatingDesc(categoryId)
                    : productRepository.findByCategoryIdOrderByRatingAsc(categoryId);

            default -> productRepository.findByCategoryId(categoryId);
        };
    }

    private Page<Product> getSortedAndFilteredPageable(Long categoryId, String sort, Pageable pageable) {
        //shop/:categoryId
        //products?sort=price:desc

        String[] parts = sort.split(":");
        String field = parts[0];
        String direction = parts.length > 1 ? parts[1] : "asc";

        return switch (field.toLowerCase()) {

            case "price" -> "desc".equalsIgnoreCase(direction)

                    ? productRepository.findByCategoryIdOrderByPriceDesc(categoryId, pageable)
                    : productRepository.findByCategoryIdOrderByPriceAsc(categoryId, pageable);

            case "rating" -> "desc".equalsIgnoreCase(direction)

                    ? productRepository.findByCategoryIdOrderByRatingDesc(categoryId, pageable)
                    : productRepository.findByCategoryIdOrderByRatingAsc(categoryId, pageable);

            default -> productRepository.findByCategoryId(categoryId, pageable);
        };
    }

}
