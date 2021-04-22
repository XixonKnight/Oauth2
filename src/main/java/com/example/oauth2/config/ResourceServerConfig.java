package com.example.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by NhanNguyen on 4/16/2021
 *
 * @author: NhanNguyen
 * @date: 4/16/2021
 */

@Configuration
@EnableResourceServer
public class ResourceServerConfig implements ResourceServerConfigurer {

    private static final String RESOURCE_ID = "inventory";

    @Autowired
    public TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resource) throws Exception {
        resource.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
       http.csrf().disable()
               .anonymous().disable()
               .authorizeRequests()
               .antMatchers(HttpMethod.GET,"/client/**").permitAll()
               .anyRequest().permitAll()
               .and()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
