package org.mealtracker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = { "spring.config.location=/home/mrr4/workspace/meal-tracker/meal-tracker-backend/dist/application.yaml" })

public class MealtrackerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
