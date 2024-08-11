package com.zerobase.project5.domain.product.service;

import java.util.List;

public interface ProductService {
    boolean registerProduct(ProductCommand.RegisterProductRequest request);

    List<ProductCommand.ProductInfoResponse> getProductList(String organizationCode);
}
