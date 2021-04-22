package com.example.oauth2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by NhanNguyen on 4/16/2021
 *
 * @author: NhanNguyen
 * @date: 4/16/2021
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "dbo_user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "guid")
    private String guid;

    @Column(name = "username")
    private String username;

    @Column(name = "passwordHah")
    private String passwordHash;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "enable")
    private boolean enable;

    @Column(name = "accountNonExpirred")
    private boolean accountNonExpired;

    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;

    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "dbo_user_role",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
    private List<Role> roles;

    public User(User user) {
        this.username = user.getUsername();
        this.passwordHash = user.getPasswordHash();
        this.gender = user.getGender();
        this.dob = user.getDob();
        this.createdDate = user.getCreatedDate();
        this.enable = user.isEnable();
        this.accountNonExpired = user.isAccountNonExpired();
        this.credentialsNonExpired = user.isCredentialsNonExpired();
        this.accountNonLocked = user.isAccountNonLocked();
        this.roles = user.getRoles();
    }
}
