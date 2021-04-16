package com.example.oauth2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
@Entity(name = "dbo_permission")
public class Permission {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;
}
