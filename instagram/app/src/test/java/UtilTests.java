import com.fasterxml.jackson.core.JsonProcessingException;
import io.dustin.apps.common.utils.CommonUtil;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;

import java.util.Arrays;
import java.util.List;

class parent{
	public int compute(int num){
		if(num <=1) return num;
		return compute(num-1) + compute(num-2);
	}
}

class Child extends parent {
	public int compute(int num){
		if(num<=1) return num;
		return compute(num-1) + compute(num-3);
	}
}

class good{
	@Test
	public static void main (String[] args){
		parent obj = new Child();
		System.out.print(obj.compute(4));
	}

	@Test
	public void LIST_TEST() {

		List<Long> list = Arrays.asList(1L,2L,3L,4L);
		System.out.print(list.contains(0L));
	}

	@Test
	public void toJson_TEST() {
		parent par = new parent();
		try {
			String toString = CommonUtil.toJson(par);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
			throw new IllegalArgumentException(e.getMessage());
		}
	}

}


public class Test {

	//
	//
	public void updateTitle(Entity entity, String title) {
		entity.setTitle(title);
	}

}


//UPDATE BOARD
// set title = "",
//     board = "",
//
public class UseCase {
	private final Test test;

	@Transactional
	public void execute() {
		em.transactionStart()
		//
		//
		//
		test.updateTitle("changed");

		//
		//
		//
		//
		//


		em.commitAndFlush()

	}

}
