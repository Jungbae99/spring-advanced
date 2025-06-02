package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallBack;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository // component scan 의 대상
public class OrderRepositoryV5 {

    private final LogTrace trace;
    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace, LogTrace logtrace) {
        this.trace = trace;
        this.template = new TraceTemplate(logtrace);
    }

    public void save(String itemId) {
        template.execute("OrderRepositoryV5.save()", () -> {
            // 저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            return null;
        });
     }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
