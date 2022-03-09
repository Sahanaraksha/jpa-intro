package com.skillsoft.jpa;

import javax.persistence.*;

@Entity
public class EmployeeContactInfo {

    @Id
    private Long id;

    private String address;
    private String phoneNum;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Employees employee;

    public EmployeeContactInfo() {
    }

    public EmployeeContactInfo(String address, String phoneNum) {

        this.address = address;
        this.phoneNum = phoneNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeContactInfo{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}