package am.smartcode.ecommerce.config.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitConfig {



    private final InitHelper initHelper;

    @PostConstruct
    public void init() {
        initHelper.createRoleAndAdmin();
    }

}
