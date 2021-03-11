package com.aleks.server.configuration;


import com.aleks.server.repo.PlayerRepo;
import com.aleks.server.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
  @Autowired
  private PlayerRepo playerRepo;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
  {
    auth
        .userDetailsService(new UserDetailsServiceImpl(playerRepo))
        .passwordEncoder(new BCryptPasswordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    http
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .usernameParameter("username")
        .passwordParameter("password")
        .and()
        .httpBasic()
        .and()
        .csrf().disable();
  }
}
