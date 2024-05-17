package com.gab1machine.fridge.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserServices userServices;

    @PostMapping
    public @ResponseBody UserDto createUser(@RequestBody UserDto season) {
        return this.userServices.createUser(season);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<UserDto> getUser(@RequestParam(name = "id") UUID id) {
        Optional<UserDto> dto = this.userServices.getUser(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}