package com.mysite.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mysite.web.answer.AnswerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.mysite.web.question.QuestionRepository;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class WebApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Transactional // 메서드가 종료될 때 까지 db연결을 유지시켜 준다.
	@Test
	void testJpa() {
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size()); // assertEquals(기대값, 실제값)
//
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject()); // 데이터 제목이 일치한지도 테스트한다.

//		Optional<Question> op = this.questionRepository.findById(1);
//		if(op.isPresent()){ // id값이 null인지 아닌지 확인한다.
//			Question q = op.get(); // 객체값을 얻어 온 후
//			assertEquals("sbb가 무엇인가요?", q.getSubject()); // 일치하는지 테스트한다
//		}

//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1, q.getId());
//
//		Question q = this.questionRepository.findBySubjectAndContent(
//				"sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//		assertEquals(1, q.getId());

//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());

//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);

//		assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());

//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q); // 어떤 질문의 답변인지 알기 위해서 Question 객체가 필요하다.
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);

//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());

//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		List<Answer> answerList = q.getAnswerList();
//
//		assertEquals(1, answerList.size());
//		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());




	}

}
