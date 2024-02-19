package am.smartcode.ecommerce.service.admin;
import am.smartcode.ecommerce.model.dto.user.UpdateUserDto;
import am.smartcode.ecommerce.model.dto.user.UserDto;

import java.util.List;

public interface AdminService {
    UserDto getById(int id);

    void delete(int id);

    List<UserDto> getAll();

    UserDto update(UpdateUserDto updateUserDto, int id);
}