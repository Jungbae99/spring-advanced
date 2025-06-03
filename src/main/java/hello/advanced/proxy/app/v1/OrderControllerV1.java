package hello.advanced.proxy.app.v1;

import org.springframework.web.bind.annotation.*;

@RestController // 스프링은 @Controller 또는 @RequestMapping 이 있어야
@ResponseBody
public interface OrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}
