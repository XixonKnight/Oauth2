package com.example.oauth2.ultis;

import com.example.oauth2.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by NhanNguyen on 4/16/2021
 *
 * @author: NhanNguyen
 * @date: 4/16/2021
 */
public class AuthUserDetail extends User implements UserDetails {


    public AuthUserDetail(User user) {
    }

    public AuthUserDetail() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> lstGrant = new ArrayList<>();
        super.getRoles().forEach(role -> {
            lstGrant.add(new SimpleGrantedAuthority(role.getName()));
            role.getPermissions().forEach(permission -> {
                lstGrant.add(new SimpleGrantedAuthority(permission.getName()));
            });
        });
        return null;
    }

    @Override
    public String getPassword() {
        return super.getPasswordHash();
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return super.isEnable();
    }
}
