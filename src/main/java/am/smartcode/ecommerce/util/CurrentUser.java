package am.smartcode.ecommerce.util;

import am.smartcode.ecommerce.model.dto.user.UserDetailsImpl;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class CurrentUser {

    public static Integer getId() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getId();
    }

}
