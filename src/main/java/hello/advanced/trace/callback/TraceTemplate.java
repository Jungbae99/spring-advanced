package hello.advanced.trace.callback;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Component;

// template 이라는 것은 변하지 않는 것, 변하는 부분은 인자로 받을것. callback 이라는 인터페이스를 받았음
public class TraceTemplate {
    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallBack<T> callBack) {
        TraceStatus status = null;

        try {
            status = trace.begin(message);
            // 로직 호출
            T result = callBack.call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

}
