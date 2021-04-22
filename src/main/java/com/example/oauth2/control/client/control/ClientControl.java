package com.example.oauth2.control.client.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NhanNguyen on 4/22/2021
 *
 * @author: NhanNguyen
 * @date: 4/22/2021
 */
@RestController
@RequestMapping("/client")
public class ClientControl {

    @GetMapping("/add")
    public String demo(){
        return "demo";
    }
}
