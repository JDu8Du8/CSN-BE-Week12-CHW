import java.util.*;
import org.junit.jupiter.api.Test;

public class TestDemo {

//#2.a, 2.b Return sum of positives or throw error.
	public int addPositive(int a, int b){
		if(a > 0 && b > 0)
			return a+b;
		else
			throw new IllegalArgumentException("Both parameters must be positive!");
	}

//#5
	@Test
	int randomNumberSquared() {
		return (int) Math.pow(getRandomInt(), 2);
	}
	
	@Test
	int getRandomInt() {
		Random random = new Random();
		  return random.nextInt(10) + 1;
		}
	
	public static void main(String[] args) {
		
	}
}
