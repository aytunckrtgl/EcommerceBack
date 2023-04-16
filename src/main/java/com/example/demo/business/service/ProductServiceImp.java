package com.example.demo.business.service;

import com.example.demo.business.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDto> listAll() {

        return productRepository.findAll().stream()
                .map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public List<ProductDto> listCategory(long departmentId) {

        return productRepository.findProductsOfDepartment(departmentId).stream()
                .map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public ProductDto listProduct(long productId) {

        return productRepository.findById(productId).map(this::toDto)
                .orElseThrow();
    }

    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setLongDescription(product.getLongDescription());
        productDto.setShortDescription(product.getShortDescription());
        return productDto;
    }
}
