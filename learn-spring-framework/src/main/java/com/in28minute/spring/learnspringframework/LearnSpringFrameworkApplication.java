package com.in28minute.spring.learnspringframework;

import com.in28minute.spring.learnspringframework.enterprise.MyWebController;
import com.in28minute.spring.learnspringframework.game.GameRunner;
import com.in28minute.spring.learnspringframework.game.MarioGame;
import com.in28minute.spring.learnspringframework.game.PacManGame;
import com.in28minute.spring.learnspringframework.game.SuperContraGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(LearnSpringFrameworkApplication.class, args);
//		MarioGame game = new MarioGame();
//		SuperContraGame superContraGame = new SuperContraGame();
//		PacManGame pacManGame = new PacManGame();
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();

		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());
	}

}
