package com.zerobase.project5.domain.product.controller;

import com.zerobase.project5.common.response.CommonResponse;
import com.zerobase.project5.domain.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fintech/v1/product")
@Tag(name = "상품 정보 API", description = "상품 정보 API 이다.")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "상품 정보 조회 API")
    @GetMapping("/{organizationCode}")
    public CommonResponse<List<ProductDto.ProductResponse>> getProductInfo(
            @Schema(description = "기관 코드")
            @PathVariable String organizationCode
    ) {
        return CommonResponse.success(
                productService.getProductList(organizationCode).stream()
                        .map(ProductDto.ProductResponse::of)
                        .collect(Collectors.toList())
        );
    }

    @Operation(summary = "상품 정보 수신 API")
    @PostMapping("/information")
    public CommonResponse registerProduct(
            @RequestBody ProductDto.RegisterProductRequest organizationCode
    ) {
        productService.registerProduct(organizationCode.toRegisterProductRequest());
        return CommonResponse.success();
    }
}
