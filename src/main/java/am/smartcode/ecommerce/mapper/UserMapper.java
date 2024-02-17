package am.smartcode.ecommerce.mapper;

import am.smartcode.ecommerce.model.dto.auth.RegisterRequestDto;
import am.smartcode.ecommerce.model.dto.user.CreateUserDto;
import am.smartcode.ecommerce.model.dto.user.UpdateUserDto;
import am.smartcode.ecommerce.model.dto.user.UserDto;
import am.smartcode.ecommerce.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "birthday", source = "age")
    UserEntity toEntity(CreateUserDto createUserDto);

    @Mapping(target = "birthday", source = "age")
    UserEntity toEntity(RegisterRequestDto requestDto);

    @Mapping(target = "birthday", source = "age")
    void update(@MappingTarget UserEntity user, UpdateUserDto updateUserDto);

    @Mapping(target = "age", source = "birthday")
    UserDto toDto(UserEntity userEntity);
}
