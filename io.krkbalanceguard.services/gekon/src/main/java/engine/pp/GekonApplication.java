package engine.pp;

import engine.pp.services.windowService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.boot.builder.SpringApplicationBuilder;
import java.awt.EventQueue;

@Controller
@EnableAutoConfiguration
@ComponentScan({"engine.pp.services"})
public class GekonApplication {

	public static void main(String[] args) {

		var ctx = new SpringApplicationBuilder(GekonApplication.class)
				.headless(false).run(args);
		EventQueue.invokeLater(() -> {
			var ex = ctx.getBean(windowService.class);
			//ex.setVisible(true);
		});
	}
}
