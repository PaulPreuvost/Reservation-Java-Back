package com.gab1machine.fridge.authentication;

import com.gab1machine.fridge.user.UserDto;
import com.gab1machine.fridge.user.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(path = "/user/authenticate")
@RestController
public class AuthenticationController {
    private final UserServices userServices;
    private final AuthenticationServices authenticationServices;

    @PostMapping
    public @ResponseBody ResponseEntity<String> authenticate(@RequestBody UserAuthenticationDto dto) {
        if (this.userServices.userExist(dto.email(), dto.hashedPassword()))
            return ResponseEntity.ok("Ok");
        return ResponseEntity.badRequest().body("Not found");
    }
}
