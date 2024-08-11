package com.zerobase.project5.domain.product.domain;

import com.zerobase.project5.common.exception.InvalidParamException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ProductCode {

    PRODUCT1("001"),
    PRODUCT2("002")
    ;

    private final String productCode;

    public static ProductCode ofProductCode(final String productCode) {
        return Arrays.stream(ProductCode.values())
                .filter(v -> v.getProductCode().equals(productCode))
                .findAny()
                .orElseThrow(() -> new InvalidParamException(String.format("Product code '%s' not found", productCode)));
    }
}
