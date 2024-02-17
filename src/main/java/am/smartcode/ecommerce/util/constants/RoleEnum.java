package am.smartcode.ecommerce.util.constants;

import lombok.Getter;

@Getter
public enum RoleEnum {

    ADMIN("ADMIN"),
    USER("USER");

    RoleEnum(String name) {
        this.name = name;
    }

    final String name;

}
