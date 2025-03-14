package arsw.wherewe.back.mazorcausers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MazorcausersApplicationTests {


	@Test
	void contextLoads() {
		// this method is empty because it is not necessary
	}

	@Test
	void applicationContextInitialized() {
		MazorcausersApplication application = new MazorcausersApplication();
		assertNotNull(application);
	}
}