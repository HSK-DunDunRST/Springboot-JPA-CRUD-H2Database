package com.mysite.sbb.Question;

import java.security.Principal;
import java.util.List;

import com.mysite.sbb.Answer.AnswerForm;
import com.mysite.sbb.User.SiteUser;
import com.mysite.sbb.User.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;  // 질문 처리 서비스
    private final UserService userService;           // 사용자 처리 서비스

    /* 질문 목록 페이지 요청 처리 (페이지 및 검색어 파라미터 포함) */
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "kw", defaultValue = "") String kw) {
        Page<Question> questionPage = this.questionService.getList(page, kw);
        model.addAttribute("questionPage", questionPage);
        model.addAttribute("kw", kw);
        return "question_list";
    }

    /* 특정 질문의 상세 페이지 요청 처리 */
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);  // 질문 정보 가져오기
        model.addAttribute("question", question);  // 모델에 질문 정보 추가
        return "question_detail";  // 질문 상세 페이지 반환
    }

    /* 질문 생성 페이지 요청 처리 (로그인된 사용자만 접근 가능) */
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";  // 질문 작성 폼 페이지 반환
    }

    /* 질문 생성 요청 처리 (로그인된 사용자만 접근 가능) */
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "question_form";  // 폼에 오류가 있는 경우 작성 폼 페이지로 돌아가기
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());  // 현재 사용자 정보 가져오기
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);  // 질문 생성
        return "redirect:/question/list";  // 질문 목록 페이지로 리디렉션
    }

    /* 질문 수정 페이지 요청 처리 (로그인된 사용자만 접근 가능) */
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, Principal principal) {
        Question question = this.questionService.getQuestion(id);  // 질문 정보 가져오기
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");  // 수정 권한이 없는 경우 예외 발생
        }
        questionForm.setSubject(question.getSubject());  // 기존 질문 제목 설정
        questionForm.setContent(question.getContent());  // 기존 질문 내용 설정
        return "question_form";  // 질문 수정 폼 페이지 반환
    }

    /* 질문 수정 요청 처리 (로그인된 사용자만 접근 가능) */
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String questionModify(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal,
                                 @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "question_form";  // 폼에 오류가 있는 경우 작성 폼 페이지로 돌아가기
        }
        Question question = this.questionService.getQuestion(id);  // 질문 정보 가져오기
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");  // 수정 권한이 없는 경우 예외 발생
        }
        this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());  // 질문 수정
        return String.format("redirect:/question/detail/%s", id);  // 수정된 질문 상세 페이지로 리디렉션
    }

    /* 질문 삭제 페이지 요청 처리 (로그인된 사용자만 접근 가능) */
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String questionDelete(Principal principal, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);  // 질문 정보 가져오기
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");  // 삭제 권한이 없는 경우 예외 발생
        }
        this.questionService.delete(question);  // 질문 삭제
        return "redirect:/";  // 홈 페이지로 리디렉션
    }

    /* 질문 추천 처리 (로그인된 사용자만 접근 가능) */
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}")
    public String questionVote(Principal principal,
                               @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);  // 질문 정보 가져오기
        SiteUser siteUser = this.userService.getUser(principal.getName());  // 현재 사용자 정보 가져오기
        this.questionService.vote(question, siteUser);  // 질문 추천
        return String.format("redirect:/question/detail/%s", id);  // 추천된 질문의 상세 페이지로 리디렉션
    }
}
