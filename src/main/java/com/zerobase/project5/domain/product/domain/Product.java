package com.zerobase.project5.domain.product.domain;

import com.zerobase.project5.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Convert(converter = OrganizationConverter.class)
    private OrganizationCode orgCd;

    @Convert(converter = ProductCodeConverter.class)
    private ProductCode prodCd;

    private String prodNm;

    private Double prodMinIntr;
    private Double prodMaxIntr;

}
