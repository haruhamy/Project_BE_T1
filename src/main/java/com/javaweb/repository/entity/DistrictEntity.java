package com.javaweb.repository.entity;

public class DistrictEntity {

    private Long id;          // ID của quận
    private String code;      // Mã quận (ví dụ: Q1, Q2)
    private String name;      // Tên quận (ví dụ: Quận 1, Quận 2)

    // Constructors
    public DistrictEntity() {
    }

    public DistrictEntity(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

