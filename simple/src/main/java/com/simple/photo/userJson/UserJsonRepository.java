package com.simple.photo.userJson;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.photo.user.User;

public interface UserJsonRepository extends JpaRepository<UserJson, Long>{

}
