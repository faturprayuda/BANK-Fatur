package com.wss.assignment.repositories;

import com.wss.assignment.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<Users, Integer> {
    public List<Users> findByIdentityNumber(String identityNumber);

    public Users findById(int id);
}
