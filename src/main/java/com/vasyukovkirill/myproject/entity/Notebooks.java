package com.vasyukovkirill.myproject.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notebooks")
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Notebooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "record")
    private String record;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User usersId;

    @Column(name = "lastchange")
    @LastModifiedDate
    private LocalDateTime lastChange;

}
