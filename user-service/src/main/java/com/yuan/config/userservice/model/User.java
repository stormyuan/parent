package com.yuan.config.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "config_user")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "company_id", nullable = false)
    private String companyId;

    @Column(name = "name")
    private String name;
}
