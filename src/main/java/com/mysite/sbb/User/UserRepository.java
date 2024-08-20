package com.mysite.sbb.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser,Long> {

    // 사용자 ID를 조회하는 기능
    Optional<SiteUser> findByusername(String username);

}
