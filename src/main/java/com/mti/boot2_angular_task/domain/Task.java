package com.mti.boot2_angular_task.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data // from lombok what create getter and setter along with to string and hash, so we don't need to create them by hand
@AllArgsConstructor // from lombok, create a constructor using all arguments used
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dueDate;
    private Boolean completed;

    //Default constructor needs when using lombok
    public Task() {
    }
}
