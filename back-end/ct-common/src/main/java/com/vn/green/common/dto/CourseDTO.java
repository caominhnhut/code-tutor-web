package com.vn.green.common.dto;

import com.vn.green.common.enums.Status;

public class CourseDTO {

    private Long id;

    private String name;

    private String description;

    private String iconUri;

    private String createdBy;

    private int orderId;

    private int amountLesson;

    private Status status;

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

    public String getIconUri() {

        return iconUri;
    }

    public void setIconUri(String iconUri) {

        this.iconUri = iconUri;
    }

    public String getCreatedBy() {

        return createdBy;
    }

    public void setCreatedBy(String createdBy) {

        this.createdBy = createdBy;
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

    public Status getStatus() {

        return status;
    }

    public void setStatus(Status status) {

        this.status = status;
    }
}
