package am.smartcode.ecommerce.controller;

import am.smartcode.ecommerce.model.dto.user.ChangePasswordDto;
import am.smartcode.ecommerce.model.dto.user.UpdateUserDto;
import am.smartcode.ecommerce.model.dto.user.UserDto;
import am.smartcode.ecommerce.service.auth.AuthService;
import am.smartcode.ecommerce.service.user.UserService;
import am.smartcode.ecommerce.util.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/password")
    @PreAuthorize("hasAnyRole('USER')")
        public ResponseEntity<Void> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        authService.changePassword(changePasswordDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<UserDto> getSelfData() {
        return ResponseEntity.ok(userService.getById(CurrentUser.getId()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<UserDto> update(@RequestBody UpdateUserDto updateUserDto, @PathVariable Integer id) {
        return ResponseEntity.ok(userService.update(updateUserDto, id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
