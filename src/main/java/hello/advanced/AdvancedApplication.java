package hello.advanced;

import hello.advanced.proxy.config.AppV1Config;
import hello.advanced.proxy.config.AppV2Config;
import hello.advanced.proxy.config.v1_proxy.ConcreteProxyConfig;
import hello.advanced.proxy.config.v1_proxy.InterfaceProxyConfig;
import hello.advanced.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import hello.advanced.proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import hello.advanced.proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import hello.advanced.proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import hello.advanced.proxy.config.v4_autoproxy.AutoProxyConfig;
import hello.advanced.proxy.config.v4_postprocessor.BeanPostProcessorConfig;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import(ProxyFactoryConfigV2.class)
@Import(AutoProxyConfig.class)
@SpringBootApplication(scanBasePackages = "hello.advanced.proxy.app.v3")
public class AdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
