package com.example.blogclone.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration //서버기 기동되는 순간 스프링 설정ㅇ
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
@EnableGlobalMethodSecurity(securedEnabled = true) // @Secured 어노테이션 활성화


public class WebSecurityConfig {
    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }





    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
// h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
        return (web) -> web.ignoring()
                //.antMatchers("/user/signup/**");
                .antMatchers("/h2-console/**");

    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

//       http
//                .authorizeHttpRequests((authz) -> authz
//                        // 어떤 요청이든 '인증'
//                        .anyRequest().permitAll()
//                );
        http.authorizeRequests()
// image 폴더를 login 없이 허용
                .antMatchers("/user/login/**").permitAll()
                .antMatchers("/images/**").permitAll()
// css 폴더를 login 없이 허용
                .antMatchers("/templates/**").permitAll()
// 회원 관리 처리 API 전부를 login 없이 허용
                .antMatchers("/user/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/css/**").permitAll()
// 그 외 어떤 요청이든 '인증'
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    // 로그인 View 제공 (GET /user/login)
                    .loginPage("/user/login")
                    // 로그인 처리 (POST /user/login)
                    .loginProcessingUrl("/user/login")
                    // 로그인 처리 후 성공 시 URL
                    .defaultSuccessUrl("/")
                    // 로그인 처리 후 실패 시 URL
                    .failureUrl("/user/login?error")
                    .permitAll()
                .and()
                    // [로그아웃 기능]
                    .logout()
                    // 로그아웃 요청 처리 URL
                    .logoutUrl("/user/logout")
                    .logoutSuccessUrl("/user/login") // 로그아웃 성공 후 이동페이지
                    .permitAll()
                    .and()
                    .exceptionHandling();
        // "접근 불가" 페이지 URL 설정

        return http.build();
    }
}