package com.simple.photo.userJson;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.photo.user.UserEntity;

public interface UserJsonRepository extends JpaRepository<UserJsonEntity, Long>{

}
