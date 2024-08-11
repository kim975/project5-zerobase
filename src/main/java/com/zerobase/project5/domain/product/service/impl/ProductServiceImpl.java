package com.zerobase.project5.domain.product.service.impl;

import com.zerobase.project5.domain.product.domain.OrganizationCode;
import com.zerobase.project5.domain.product.repository.ProductRepository;
import com.zerobase.project5.domain.product.repository.ProductListRepository;
import com.zerobase.project5.domain.product.service.ProductCommand;
import com.zerobase.project5.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductListRepository productListRepository;

    @Override
    public List<ProductCommand.ProductInfoResponse> getProductList(String organizationCode) {
        return productRepository.findAllByOrgCd(OrganizationCode.ofOrganizationCode(organizationCode))
                .stream()
                .map(ProductCommand.ProductInfoResponse::of)
                .collect(Collectors.toList());
    }

    @Override
    public boolean registerProduct(ProductCommand.RegisterProductRequest request) {
        productRepository.save(request.toEntityForProductInfo());
        productListRepository.save(request.toEntityForProductList());
        return true;
    }



}
