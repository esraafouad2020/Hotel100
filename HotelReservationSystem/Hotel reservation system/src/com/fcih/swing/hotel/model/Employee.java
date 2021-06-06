package com.fcih.swing.hotel.model;

import com.fcih.swing.hotel.entity.annotation.Column;

public class Employee implements Model{

    @Column(value = "id")
    private Integer id;
    
    @Column(value = "code")
    private Integer code;
    
    private String password;

    @Column(value = "name")
    private String name;
    
    @Column(value = "address")
    private String address;
    
    @Column(value = "mail")
    private String mail;
    
    @Column(value = "phone")
    private Long phone;
    
    @Column(value = "salary")
    private Float salary;
    
    @Column(value = "super_user")
    private String superuser;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
    
    public boolean isSuperuser() {
        return getSuperuser().equalsIgnoreCase("Y");
    }

    public String getSuperuser() {
        return superuser;
    }

    public void setSuperuser(String superuser) {
        this.superuser = superuser;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
