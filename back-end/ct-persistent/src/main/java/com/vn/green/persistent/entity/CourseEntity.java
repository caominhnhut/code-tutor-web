package com.vn.green.persistent.entity;

import javax.persistence.*;

@Entity
@Table(name = "course")
@SequenceGenerator(name = "course_id_generator", sequenceName = "course_id_seq", allocationSize = 1)
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_id_generator")
    private Long id;

    @Column(name = "courseName")
    private String courseName;

    @Column(name = "lesson")
    private Long lesson;

    @Column(name = "description")
    private String description;

    @Column(name = "iconUri")
    private String iconUri;

    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getLesson() {
        return lesson;
    }

    public void setLesson(Long lesson) {
        this.lesson = lesson;
    }

    public String getIconUri() {
        return iconUri;
    }

    public void setIconUri(String iconUri) {
        this.iconUri = iconUri;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
