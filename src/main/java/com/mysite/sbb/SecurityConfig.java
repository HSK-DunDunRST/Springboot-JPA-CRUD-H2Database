package com.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    // CSRF 검증과 로그인 처리
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        /* 인증되지 않은 모든 페이지 요청을 허락하는 코드 -> 로그인을 하지 않더라도 페이지 접근 가능 */
        httpSecurity.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
                /* localhost:5000/h2-console 주소를 CSRF 검증하지 않는다. */
                .csrf((csrf) -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
                /* h2-console 화면이 프레임구조의 레이아웃이기때문에 해결하기 위한 코드. */
                .headers((headers)-> headers.addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
                /* 로그인 요청시 처리 코드 */
                .formLogin((formLogin) -> formLogin.loginPage("/user/login")
                        /* 로그인 성공시 Root 페이지 경로로 이동. */
                        .defaultSuccessUrl("/"))
                /* 로그아웃 요청시 처리 코드 */
                .logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                        /* 로그아웃 성공시 Root 페이지 경로로 이동.*/
                        .logoutSuccessUrl("/")
                        /* 로그아웃 시 생성된 사용자 세선 삭제 */
                        .invalidateHttpSession(true));
        return httpSecurity.build();
    }
    // 사용자 비밀번호 암호화 처리
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    // 사용자 인증 처리
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
