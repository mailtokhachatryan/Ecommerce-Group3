package am.smartcode.ecommerce.service.admin;

import am.smartcode.ecommerce.model.dto.user.UpdateUserDto;
import am.smartcode.ecommerce.model.dto.user.UserDto;

import java.util.List;

public interface AdminUserService {

    UserDto update(UpdateUserDto updateUserDto, int id);

    UserDto getById(int id);

    List<UserDto> getAll();

    void delete(int id);

    UserDto getByEmail(String email);

}
