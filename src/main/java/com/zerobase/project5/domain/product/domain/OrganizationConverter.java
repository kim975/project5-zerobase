package com.zerobase.project5.domain.product.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class OrganizationConverter implements AttributeConverter<OrganizationCode, String> {
    @Override
    public String convertToDatabaseColumn(OrganizationCode organizationCode) {
        return organizationCode.getOrganizationCode();
    }

    @Override
    public OrganizationCode convertToEntityAttribute(String organizationCode) {
        return OrganizationCode.ofOrganizationCode(organizationCode);
    }
}
