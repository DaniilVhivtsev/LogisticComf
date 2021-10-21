package com.logisticcomfort.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Ware")
public class Warehouse {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String warehouseName;
    private String phoneNumber;
    private String addressWarehouse;

//    @ManyToOne (optional=true, cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//    private Company company;

//    @OneToMany(mappedBy="company", fetch = FetchType.LAZY)
//    private Set<Warehouse> warehouse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressWarehouse() {
        return addressWarehouse;
    }

    public void setAddressWarehouse(String addressWarehouse) {
        this.addressWarehouse = addressWarehouse;
    }

//    public Set<Warehouse> getAuthor() {
//        return warehouse;
//    }
//
//    public void setAuthor(Set<Warehouse> author) {
//        this.warehouse = author;
//    }
//
//    public void addAuthor(Warehouse author) {
//        this.warehouse.add(author);
//    }
//
//    public Company getCompany() {
//        return company;
//    }
//
//    public void setCompany(Company company) {
//        this.company = company;
//    }
}
