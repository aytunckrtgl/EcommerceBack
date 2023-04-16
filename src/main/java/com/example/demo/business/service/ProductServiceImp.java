package com.example.demo.business.service;

import com.example.demo.business.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDto> listAll() {
        List<ProductDto> productsDto = new ArrayList<ProductDto>();
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            productsDto.add(toDto(product));
        }
        return productsDto;
    }

    @Transactional
    public List<ProductDto> listCategory(long departmentId) {
        List<ProductDto> productsDto = new ArrayList<ProductDto>();
        Iterable<Product> products = productRepository.findProductsOfDepartment(departmentId);
        for (Product product : products) {
            productsDto.add(toDto(product));
        }
        return productsDto;

    }

    @Transactional
    public ProductDto listProduct(long productId) {
        Optional<Product> optional = productRepository.findById(productId);
        return toDto(optional.get());
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
