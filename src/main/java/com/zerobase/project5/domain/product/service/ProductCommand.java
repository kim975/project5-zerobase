package com.zerobase.project5.domain.product.service;

import com.zerobase.project5.domain.product.domain.OrganizationCode;
import com.zerobase.project5.domain.product.domain.ProductCode;
import com.zerobase.project5.domain.product.domain.Product;
import com.zerobase.project5.domain.product.domain.ProductList;
import lombok.Builder;
import lombok.Data;

public class ProductCommand {

    @Data
    @Builder
    public static class RegisterProductRequest {
        private String organizationCode;
        private String productCode;
        private Double productMaximumInterest;
        private Double productMinimumInterest;
        private String productName;


        public Product toEntityForProductInfo() {
            return Product.builder()
                    .orgCd(OrganizationCode.ofOrganizationCode(organizationCode))
                    .prodCd(ProductCode.ofProductCode(productCode))
                    .prodMaxIntr(productMaximumInterest)
                    .prodMinIntr(productMinimumInterest)
                    .prodNm(productName)
                    .build();
        }

        public ProductList toEntityForProductList() {
            return ProductList.builder()
                    .orgCd(OrganizationCode.ofOrganizationCode(organizationCode))
                    .prodCd(ProductCode.ofProductCode(productCode))
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

        public static ProductInfoResponse of(Product productInfo) {
            return ProductInfoResponse.builder()
                    .organizationCode(productInfo.getOrgCd().getOrganizationCode())
                    .productCode(productInfo.getProdCd().getProductCode())
                    .productMaximumInterest(productInfo.getProdMaxIntr())
                    .productMinimumInterest(productInfo.getProdMinIntr())
                    .productName(productInfo.getProdNm())
                    .build();
        }

    }
}
