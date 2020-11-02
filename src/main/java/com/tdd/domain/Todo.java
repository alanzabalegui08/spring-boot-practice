package com.tdd.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
public class Todo {

    @NotNull
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotNull
    @NotBlank
    private String Description;

    @Column(insertable = true, updatable = false)
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean completed;

    @PrePersist
    void onCreate(){
        this.setCreated(LocalDateTime.now());
        this.setUpdated(LocalDateTime.now());
    }

    @PreUpdate
    void onUpdate(){
        this.setUpdated(LocalDateTime.now());
    }

}
