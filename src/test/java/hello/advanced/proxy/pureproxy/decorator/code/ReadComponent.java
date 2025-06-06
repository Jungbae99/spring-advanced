package hello.advanced.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadComponent implements Component {

    @Override
    public String operation() {
        log.info("ReadComponent 실행");
        return "data";
    }

}
