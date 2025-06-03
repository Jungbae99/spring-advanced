package hello.advanced.proxy.app.v1;

import org.springframework.stereotype.Repository;

public interface OrderRepositoryV1 {

    void save(String itemId);
}
