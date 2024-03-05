package am.smartcode.ecommerce.controller;

import am.smartcode.ecommerce.model.dto.user.UpdateUserDto;
import am.smartcode.ecommerce.model.dto.user.UserDto;
import am.smartcode.ecommerce.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminUserController {

//    TODO: Replace with AdminUserService
    private final UserService userService;


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<UserDto> update(@RequestBody UpdateUserDto updateUserDto, @PathVariable Integer id) {
        return ResponseEntity.ok(userService.update(updateUserDto, id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
