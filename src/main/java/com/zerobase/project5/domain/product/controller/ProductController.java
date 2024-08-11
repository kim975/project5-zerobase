package com.zerobase.project5.domain.product.controller;

import com.zerobase.project5.common.response.CommonResponse;
import com.zerobase.project5.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fintech/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{organizationCode}")
    public CommonResponse<List<ProductDto.ProductResponse>> getProductInfo(
            @PathVariable String organizationCode
    ) {
        return CommonResponse.success(
                productService.getProduct(organizationCode).stream()
                        .map(ProductDto.ProductResponse::of)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping("/information")
    public CommonResponse registerProduct(
            @RequestBody ProductDto.RegisterProductRequest organizationCode
    ) {
        productService.registerProduct(organizationCode.toRegisterProductRequest());
        return CommonResponse.success();
    }
}
