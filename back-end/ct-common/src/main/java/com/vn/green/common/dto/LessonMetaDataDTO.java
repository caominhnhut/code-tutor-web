package com.vn.green.common.dto;

import java.util.Calendar;

public class LessonMetaDataDTO {

    private int amountOfLikes;

    private int amountOfComments;

    private String course;

    private String createdBy;

    private Calendar createdDate;

    public int getAmountOfLikes() {

        return amountOfLikes;
    }

    public void setAmountOfLikes(int amountOfLikes) {

        this.amountOfLikes = amountOfLikes;
    }

    public int getAmountOfComments() {

        return amountOfComments;
    }

    public void setAmountOfComments(int amountOfComments) {

        this.amountOfComments = amountOfComments;
    }

    public String getCourse() {

        return course;
    }

    public void setCourse(String course) {

        this.course = course;
    }

    public String getCreatedBy() {

        return createdBy;
    }

    public void setCreatedBy(String createdBy) {

        this.createdBy = createdBy;
    }

    public Calendar getCreatedDate() {

        return createdDate;
    }

    public void setCreatedDate(Calendar createdDate) {

        this.createdDate = createdDate;
    }
}
