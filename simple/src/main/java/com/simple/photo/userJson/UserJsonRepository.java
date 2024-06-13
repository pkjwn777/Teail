package com.simple.photo.userJson;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simple.photo.user.UserEntity;

@Repository
public interface UserJsonRepository extends JpaRepository<UserJsonEntity, Long>{
@Query(value = "select user_num from user_json where user_num = :user_num",
        nativeQuery = true)
	Optional<UserJsonEntity> findByuserNum(@Param("user_num")Long usernum);
}
