package com.example.fastcampus_project_board.service;

import com.example.fastcampus_project_board.domain.Article;
import com.example.fastcampus_project_board.domain.ArticleComment;
import com.example.fastcampus_project_board.domain.UserAccount;
import com.example.fastcampus_project_board.dto.ArticleCommentDto;
import com.example.fastcampus_project_board.repository.ArticleCommentRepository;
import com.example.fastcampus_project_board.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService sut;

    @Mock private ArticleCommentRepository articleCommentRepository;
    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글 ID로 조회하면, 해당하는 댓글 리스트를 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticleComments_thenReturnsArticleComments() {
        // Given
        Long articleId = 1L;
        ArticleComment expected = createArticleCommment("content");
        given(articleRepository.findById(articleId)).willReturn(Optional.of(
                Article.of(createUserAccount(), "title", "content", "#java")
        ));

        // When
        List<ArticleCommentDto> actual = sut.searchArticleComment(articleId);

        // Then
        assertThat(actual).isNotNull();
        then(articleRepository).should().findById(articleId);

    }

    private ArticleComment createArticleCommment(String content) {
        return ArticleComment.of(
                Article.of(createUserAccount(), "title", "content", "hashtag"),
                createUserAccount(),
                content
        );
    }

    private UserAccount createUserAccount() {
        return UserAccount.of(
                "seo",
                "password",
                "seo@email.com",
                "Seo",
                null
        );
    }
}