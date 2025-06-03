package hello.advanced.proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnotherProxy extends ConcreteLogic {

    private ConcreteLogic concreteLogic;

    public AnotherProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation() {
        log.info("ㅎㅇㅎㅇ another");
        return concreteLogic.operation();
    }
}
