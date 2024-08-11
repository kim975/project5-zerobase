package com.zerobase.project5.domain.product.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ProductCodeConverter implements AttributeConverter<ProductCode, String> {

    @Override
    public String convertToDatabaseColumn(ProductCode productCode) {
        return productCode.getProductCode();
    }

    @Override
    public ProductCode convertToEntityAttribute(String productCode) {
        return ProductCode.ofProductCode(productCode);
    }
}
