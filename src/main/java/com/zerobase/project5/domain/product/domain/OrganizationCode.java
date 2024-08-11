package com.zerobase.project5.domain.product.domain;

import com.zerobase.project5.common.exception.BaseException;
import com.zerobase.project5.common.exception.InvalidParamException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum OrganizationCode {

    Company1("00001");

    private final String organizationCode;

    public static OrganizationCode ofOrganizationCode(final String organizationCode) {
        return Arrays.stream(OrganizationCode.values())
                .filter(v -> v.getOrganizationCode().equals(organizationCode))
                .findAny()
                .orElseThrow(() -> new InvalidParamException(String.format("Organization code '%s' not found", organizationCode)));
    }
}
