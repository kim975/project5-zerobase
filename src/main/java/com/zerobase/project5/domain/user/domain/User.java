package com.zerobase.project5.domain.user.domain;

import com.zerobase.project5.common.encrypt.Encrypt;
import com.zerobase.project5.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String usrKey;

    @Encrypt
    private String usrRegNum;

    private String usrNm;

    private Long usrIcmAmt;

}
