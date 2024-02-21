package am.smartcode.ecommerce.controller.user;

import am.smartcode.ecommerce.model.dto.user.UpdateUserDto;
import am.smartcode.ecommerce.model.dto.user.UserDto;
import am.smartcode.ecommerce.service.admin.AdminService;
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

import java.util.List;

@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminUserController {
    private final AdminService adminService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(adminService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.getById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<UserDto> update(@RequestBody UpdateUserDto updateUserDto, @PathVariable Integer id) {
        return ResponseEntity.ok(adminService.update(updateUserDto, id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        adminService.delete(id);
        return ResponseEntity.ok().build();
    }

}