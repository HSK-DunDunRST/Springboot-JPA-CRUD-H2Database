package com.mysite.sbb.Question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.mysite.sbb.Answer.Answer;
import com.mysite.sbb.User.SiteUser;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.ManyToMany;

@Getter
@Setter
@Entity
public class Question {
    /* 질문 id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /* 질문 제목 */
    @Column(length = 200)
    private String subject;
    /* 질문 내용 */
    @Column(columnDefinition = "TEXT")
    private String content;
    /* 질문 생성 시간 */
    private LocalDateTime createDate;
    /* 질문에 해당되는 대답 id */
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
    /* 질문 글쓴이 */
    @ManyToOne
    private SiteUser author;
    /* 질문 수정 시간 */
    private LocalDateTime modifyDate;
    /* 추천인 */
    @ManyToMany
    Set<SiteUser> voter;
}
