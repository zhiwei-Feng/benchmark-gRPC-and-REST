package com.example.demo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhiweifeng
 */
@Getter
@Setter
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -5377262623531579234L;
    private Long id;
    private String username;
    private String password;
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

}
