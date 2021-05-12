package com.vn.green.common.dto;

public class CourseDTO {

    private Long id;

    private String name;

    private String description;

    private byte[] icon;

    private int orderId;

    private int amountLesson;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public byte[] getIcon() {

        return icon;
    }

    public void setIcon(byte[] icon) {

        this.icon = icon;
    }

    public int getOrderId() {

        return orderId;
    }

    public void setOrderId(int orderId) {

        this.orderId = orderId;
    }

    public int getAmountLesson() {

        return amountLesson;
    }

    public void setAmountLesson(int amountLesson) {

        this.amountLesson = amountLesson;
    }
}
