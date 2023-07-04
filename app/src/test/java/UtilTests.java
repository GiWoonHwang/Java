import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

@SpringBootTest
class good{
	@Test
	public static void main (String[] args){
		parent obj = new Child();
		System.out.print(obj.compute(4));
	}
}

