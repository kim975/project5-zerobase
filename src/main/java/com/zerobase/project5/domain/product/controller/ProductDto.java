package com.zerobase.project5.domain.product.controller;

import com.zerobase.project5.domain.product.service.ProductCommand;
import lombok.Builder;
import lombok.Data;

public class ProductDto {

    @Data
    public static class RegisterProductRequest {
        private String organizationCode;
        private String productCode;
        private Double productMaximumInterest;
        private Double productMinimumInterest;
        private String productName;

        public ProductCommand.RegisterProductRequest toRegisterProductRequest() {
            return ProductCommand.RegisterProductRequest.builder()
                    .organizationCode(organizationCode)
                    .productCode(productCode)
                    .productMaximumInterest(productMaximumInterest)
                    .productMinimumInterest(productMinimumInterest)
                    .productName(productName)
                    .build();
        }
    }

    @Data
    @Builder
    public static class ProductInfoResponse {
        private String organizationCode;
        private String productCode;
        private Double productMaximumInterest;
        private Double productMinimumInterest;
        private String productName;

        public static ProductInfoResponse of(ProductCommand.ProductInfoResponse productInfoResponse) {
            return ProductInfoResponse.builder()
                    .organizationCode(productInfoResponse.getOrganizationCode())
                    .productCode(productInfoResponse.getProductCode())
                    .productMaximumInterest(productInfoResponse.getProductMaximumInterest())
                    .productMinimumInterest(productInfoResponse.getProductMinimumInterest())
                    .productName(productInfoResponse.getProductName())
                    .build();
        }
    }

}
