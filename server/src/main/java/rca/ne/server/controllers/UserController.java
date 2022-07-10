package rca.ne.server.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rca.ne.server.dtos.CreateOrUpdateUserDTO;
import rca.ne.server.services.IUserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    private final IUserService userService;


    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @GetMapping
    ResponseEntity<?> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }


    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }


    @PostMapping
    ResponseEntity<?> save(@RequestBody CreateOrUpdateUserDTO user){
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@RequestBody CreateOrUpdateUserDTO user, @PathVariable Long id){
        return ResponseEntity.ok(userService.update(user,id));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> remove(@PathVariable Long id){
        return ResponseEntity.ok(userService.remove(id));
    }
}
