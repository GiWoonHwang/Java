import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import apps.noticeboard.answer.AnswerRepository;
import libs.common.utils.SelectDate;
import apps.noticeboard.question.QuestionRepository;
//import com.mysite.sbb.subscriber.SubscriberListener;
import apps.noticeboard.question.QuestionService;
import io.rigo.sdk.common.client.RigoWeb3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private RigoWeb3 rigoWeb3;

	@Autowired
	private QuestionService questionService;


//	@Transactional // 세션이 끊어지는걸 방지해준다.
@Test
void testJpa() throws InterruptedException {
//		for (int i = 1; i <= 300; i++) {
//			String subject = String.format("테스트 데이터입니다:[%03d]", i);
//			String content = "내용무";
////			this.questionService.create(subject, content);
//		}

	SelectDate data = SelectDate.TYPE_TWO;
	System.out.println("짜잔 과연 결과는 ????????????????????????"+ data.transform(LocalDateTime.now()));
	System.out.println("짜잔 과연 결과는 ????????????????????????"+ data.convertDate(LocalDateTime.now(),data.getPattern()));





	// 생성
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?"); // setter를 이용해 값 변경
//		q1.setContent("sbb에 대해서 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);

//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);  // 두번째 질문 저장

	// 조회
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//
//		Question q = all.get(0); // 0번 인덱스에 해당하는 값을 가져와서
//		assertEquals("sbb가 무엇인가요?", q.getSubject());

//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()){ // null이 아니면
//			Question q = oq.get();
//			assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}

        /*
		이러한 마법은 JpaRepository를 상속한 QuestionRepository 객체가 생성될때 벌어진다. (DI에 의해 스프링이 자동으로 QuestionRepository 객체를 생성한다. 이 때 프록시 패턴이 사용된다고 한다.)
		리포지터리 객체의 메서드가 실행될때 JPA가 해당 메서드명을 분석하여 쿼리를 만들고 실행한다.
		findBy + 엔티티의 속성명(예:findBySubject)과 같은 리포지터리 메서드를 작성하면 해당 속성의 값으로 데이터를 조회할수 있다.
		 */
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1, q.getId());

//		Question q = this.questionRepository.findBySubjectAndContent(
//				"sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//		assertEquals(1,q.getId());

        /*
		sbb%: "sbb"로 시작하는 문자열
		%sbb: "sbb"로 끝나는 문자열
		%sbb%: "sbb"를 포함하는 문자열
		 */
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());

	// 수정
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);
//
	// 삭제
//		assertEquals(2, this.questionRepository.count()); // 삭제하기 전에는 2
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count()); // 삭제한 후에는 1
//
	// 답변 데이터 생성 후 저장
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get(); // id가 2번에 해당하는 데이터 가져온다.
//
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q); // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);

	// 답변 조회하기
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId()); // 답변에 대한 질문 id가 2인지 테스트
//

	// 답변에 연결된 질문 찾기 vs 질문에 달린 답변 찾기
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();

        /*
		findById를 호출하여 Question 객체를 조회하고 나면 db세션이 끊어지기 때문에 q.getAnswerList()는 오류가 발생한다
		 */
//		List<Answer> answerList = q.getAnswerList();
//
//		assertEquals(1, answerList.size()); // 답변은 한개였으니 size는 1이 나와야 한다.
//		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());

	/*
		**************************************************************************************************************************************************
		* 블록체인 api 테스트 코드 작성
		 */
//		Account addrInfo = rigoWeb3.queryAccount("196508f1df43a562f044692ba0bd16cef992ec37");
//		assertEquals("8423",addrInfo.getValue().getNonce());


}

}
