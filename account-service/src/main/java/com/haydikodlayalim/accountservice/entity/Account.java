package com.haydikodlayalim.accountservice.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Table(value = "accounts")
public class Account implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Setter
    @Column(value = "username")
    private String username;

    @Setter
    @Column(value = "name")
    private String name;

    @Setter
    @Column(value = "surname")
    private String surname;

    @Setter
    @Column(value = "email")
    private String email;

    @Setter
    @Column(value = "birth_date")
    private Date dateBirth;

    @Setter
    @Column(value = "password")
    private String password;

    @Column(value = "created_date")
    private Date createdDate;

    @Column(value = "is_active")
    private Boolean active;
}