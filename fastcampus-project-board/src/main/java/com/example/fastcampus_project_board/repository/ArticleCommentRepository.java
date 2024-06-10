package com.example.fastcampus_project_board.repository;

import com.example.fastcampus_project_board.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}
