package com.targetindia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "shippers")
@AllArgsConstructor
@NoArgsConstructor
public class Shipper {

    @Id
    @Column(name = "shipper_id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    private String phone;

}
