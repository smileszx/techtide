package com.ai.tide.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/3 22:40
 **/
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getAuthority() {
        return name;
    }
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
