package hello.advanced.proxy.pureproxy.decorator;

import hello.advanced.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import hello.advanced.proxy.pureproxy.decorator.code.MessageDecorator;
import hello.advanced.proxy.pureproxy.decorator.code.ReadComponent;
import hello.advanced.proxy.pureproxy.decorator.code.TimeDecorator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        ReadComponent component = new ReadComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(component);

        client.execute();
    }

    @Test
    void decorator1() {
        ReadComponent component = new ReadComponent();
        MessageDecorator decorator = new MessageDecorator(component);
        DecoratorPatternClient client = new DecoratorPatternClient(decorator);

        client.execute();
    }

    @Test
    void decorator2() {
        ReadComponent component = new ReadComponent();
        MessageDecorator decorator = new MessageDecorator(component);
        TimeDecorator timeDecorator = new TimeDecorator(decorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);

        client.execute();
    }
}