package com.mysite.sbb.Answer;

import java.time.LocalDateTime;
import java.util.Set;

import com.mysite.sbb.Question.Question;
import com.mysite.sbb.User.SiteUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
    /* 답변 id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /* 답변 내용 */
    @Column(columnDefinition = "TEXT")
    private String content;
    /* 답변 생성 시간 */
    private LocalDateTime createDate;
    /* 답변에 해당되는 질문 id */
    @ManyToOne
    private Question question;
    /* 답변 글쓴이 */
    @ManyToOne
    private SiteUser author;
    /* 답변 수정 시간 */
    private LocalDateTime modifyDate;
    @ManyToMany
    /* 추천인 */
    Set<SiteUser> voter;
}
