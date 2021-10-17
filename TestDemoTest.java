import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {
//#3, #4 TestDemoTest with variables, functions, 
	
	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {

		if(!expectException) {
//assertThat would not function. 
//			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			assertEquals(expected, testDemo.addPositive(a,b));
			}
		else
			assertThatThrownBy(() -> testDemo.addPositive(a, b))
				.isInstanceOf(IllegalArgumentException.class);
	}

//#6
	@Test
	void assertThatNumberSquaredIs_Correct(){
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
//assertThat would not function. 		
//		assertThat(fiveSquared).isEqualTo(25);
		assertEquals(25, fiveSquared);
	}
	
	//Test Cases
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(arguments(2, 4, 6, false),
				arguments (2, 0, 2, true),
				arguments (-2, 1, -1, true),
				arguments (0, 0, 0, true));
	}
	

}
