package com.vn.green.common.dto;

import com.vn.green.common.enums.Status;

public class LessonDTO {

    private Long id;

    private String title;

    private String iconUri;

    private String content;

    private LessonMetaDataDTO metaData;

    private Status status;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getIconUri() {

        return iconUri;
    }

    public void setIconUri(String iconUri) {

        this.iconUri = iconUri;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public LessonMetaDataDTO getMetaData() {

        return metaData;
    }

    public void setMetaData(LessonMetaDataDTO metaData) {

        this.metaData = metaData;
    }

    public Status getStatus() {

        return status;
    }

    public void setStatus(Status status) {

        this.status = status;
    }
}
