package am.smartcode.ecommerce.service.user;

import am.smartcode.ecommerce.CustomAutowired;
import am.smartcode.ecommerce.exception.EntityNotFoundException;
import am.smartcode.ecommerce.mapper.UserMapper;
import am.smartcode.ecommerce.model.dto.user.UpdateUserDto;
import am.smartcode.ecommerce.model.dto.user.UserDto;
import am.smartcode.ecommerce.model.entity.UserEntity;
import am.smartcode.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @CustomAutowired
    private UserRepository userRepository;
    @CustomAutowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public UserDto update(UpdateUserDto updateUserDto, int id) {
        UserEntity userById = userRepository.findById(id).orElseThrow();
        userMapper.update(userById, updateUserDto);
        userRepository.save(userById);
        return userMapper.toDto(userById);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getById(int id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found")));
    }

    @Override
    @Transactional
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email));
    }


}
