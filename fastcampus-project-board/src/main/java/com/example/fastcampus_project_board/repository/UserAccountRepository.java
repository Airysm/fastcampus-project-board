package com.example.fastcampus_project_board.repository;

import com.example.fastcampus_project_board.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
