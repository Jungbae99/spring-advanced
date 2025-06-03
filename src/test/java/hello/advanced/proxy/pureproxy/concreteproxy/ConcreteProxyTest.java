package hello.advanced.proxy.pureproxy.concreteproxy;

import hello.advanced.proxy.pureproxy.concreteproxy.code.AnotherProxy;
import hello.advanced.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import hello.advanced.proxy.pureproxy.concreteproxy.code.ConcreteLogic;
import hello.advanced.proxy.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);

        concreteClient.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        AnotherProxy anotherProxy = new AnotherProxy(concreteLogic);
        TimeProxy timeProxy = new TimeProxy(anotherProxy);

        timeProxy.operation();
    }
}
