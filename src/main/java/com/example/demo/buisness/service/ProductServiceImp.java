package com.example.demo.buisness.service;

import com.example.demo.buisness.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.model.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements  ProductService{
    @Autowired
    ProductRepository productRepository;
    @Transactional
    public List<ProductDto> listAll(){
        List<ProductDto> productsDto = new ArrayList<ProductDto>();
        Iterable<Product> products = productRepository.findAll();
        for(Product product : products){
            productsDto.add(toDto(product));
        }
        return productsDto;
    }
    @Transactional
    public List<ProductDto> listCategory(long departmentId){
        List<ProductDto> productsDto = new ArrayList<ProductDto>();
        Iterable<Product> products = productRepository.findProductsOfDepartment(departmentId);
        for(Product product : products){
            productsDto.add(toDto(product));
        }
        return productsDto;

    }
    @Transactional
    public ProductDto listProduct(long productId){
        Optional<Product> optional = productRepository.findById(productId);
        return toDto(optional.get());

    }

    public ProductDto toDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setLongDescription(product.getLongDescription());
        productDto.setShortDescription(product.getShortDescription());
        return productDto;

    }
}
