package hello.advanced.proxy.config.v1_proxy;

import hello.advanced.proxy.app.v2.OrderControllerV2;
import hello.advanced.proxy.app.v2.OrderRepositoryV2;
import hello.advanced.proxy.app.v2.OrderServiceV2;
import hello.advanced.proxy.config.v1_proxy.concrete_proxy.OrderControllerConcreteProxy;
import hello.advanced.proxy.config.v1_proxy.concrete_proxy.OrderRepositoryConcreteProxy;
import hello.advanced.proxy.config.v1_proxy.concrete_proxy.OrderServiceConcreteProxy;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public OrderRepositoryV2 getOrderRepository(LogTrace logTrace) {
        OrderRepositoryV2 repository = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(repository, logTrace);
    }

    @Bean
    public OrderServiceV2 getOrderService(LogTrace logTrace) {
        OrderServiceV2 service = new OrderServiceV2(getOrderRepository(logTrace));
        return new OrderServiceConcreteProxy(service, logTrace);
    }

    @Bean
    public OrderControllerV2 getOrderController(LogTrace logTrace) {
        OrderControllerV2 controller = new OrderControllerV2(getOrderService(logTrace));
        return new OrderControllerConcreteProxy(controller, logTrace);
    }
}
