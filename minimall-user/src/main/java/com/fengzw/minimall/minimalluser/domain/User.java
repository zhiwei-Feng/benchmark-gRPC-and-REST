package com.fengzw.minimall.minimalluser.domain;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author zhiweifeng
 */
@Entity
@Getter
@Setter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 4980126213791657861L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String nickname;

    public User(Long id, String password, String nickname) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }

    public User() {
    }

    public User(Long id, String username, String password, String nickname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
