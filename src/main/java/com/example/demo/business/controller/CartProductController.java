package com.example.demo.business.controller;

import com.example.demo.business.dto.CartProductDto;
import com.example.demo.business.service.CartProductService;
import com.example.demo.model.entity.CartProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartl")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CartProductController {

    private final CartProductService cartProductService;

    @GetMapping("/{cartId}")
    public List<CartProductDto> listCart(@PathVariable("cartId") long cartId) {
        List<CartProduct> cartProductList = cartProductService.listCart(cartId);

        return cartProductList.stream()
                .map(cartProduct -> new CartProductDto(cartProduct.getProduct(), cartProduct.getSalesQuantity()))
                .toList();
    }

    @DeleteMapping("/{cartId}/delete")
    public void deleteCart(@PathVariable("cartId") long cartId) {
       cartProductService.deleteCart(cartId);

    }
}
