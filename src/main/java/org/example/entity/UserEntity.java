package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  Integer id;
    @Column(name = "name", columnDefinition = "text")
    private String name;
    @Column(name = "last_name", columnDefinition = "text")
    private String lastName;
    @Column(name = "username")
    private String username;
    @Column(name = "phone")
    private String phone;
    @Column(name = "is_premium")
    private Boolean isPremium;
    @Column(name = "chat_id",unique = true)
    private Long chatId;
    @Column(name = "added_time")
    private LocalDateTime addedTime;
}
