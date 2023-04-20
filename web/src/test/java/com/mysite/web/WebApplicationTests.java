package com.mysite.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import java.util.List;

@SpringBootTest
class WebApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

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



	}

}
