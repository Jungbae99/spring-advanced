package hello.advanced;

import hello.advanced.proxy.config.AppV1Config;
import hello.advanced.proxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
@Import(AppV1Config.class)
@SpringBootApplication(scanBasePackages = "hello.advanced.proxy.app.v3")
public class AdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedApplication.class, args);
	}

}
