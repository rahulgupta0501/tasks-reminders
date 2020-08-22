package com.inno.tasks.Entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;



@Entity
@Table(name="tasks")
@EntityListeners(AuditingEntityListener.class)
public class Task {
    @Id
    @GeneratedValue(generator = "uuid1")
    @GenericGenerator(name = "uuid1", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 15)
    private String taskName;

    @Size(min = 5, max = 30)
    private String taskDescription;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 15)
    private String userId;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Task() {
    }

    public Task(String taskName, String taskDescription, String userId) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.userId = userId;
    }

    public Task(String taskName, String userId) {
        this.taskName = taskName;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format("id = %s,name = %s,description = %s,userid = %s", id, taskName, taskDescription, userId);
    }
}
