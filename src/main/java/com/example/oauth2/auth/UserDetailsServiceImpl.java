package com.example.oauth2.auth;

import com.example.oauth2.entity.User;
import com.example.oauth2.ultis.AuthUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.oauth2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by NhanNguyen on 4/16/2021
 *
 * @author: NhanNguyen
 * @date: 4/16/2021
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));
        UserDetails userDetails = new AuthUserDetail(user.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}
