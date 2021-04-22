package com.example.oauth2.ultis;

/**
 * Created by NhanNguyen on 4/22/2021
 *
 * @author: NhanNguyen
 * @date: 4/22/2021
 */
public class Response {
    private String status;
//    private String

    public Response() {
    }

    public Response(String status) {
        this.status = status;
    }

    public static Response success(String status){
        return new Response(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
