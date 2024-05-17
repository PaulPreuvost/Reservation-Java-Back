package com.gab1machine.fridge.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserServices userServices;

    @Operation(summary = "User Creation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully created.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "User already exist.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            })
    })
    @PostMapping
    public @ResponseBody ResponseEntity<UserDto> createUser(@RequestBody UserInputDto dto) {
        Optional<UserDto> userDto = this.userServices.createUser(dto);
        return userDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Retrieved User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully retrieved.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserOutputDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Unknown User.", content = {
                    @Content()
            })
    })
    @GetMapping
    public @ResponseBody ResponseEntity<UserOutputDto> getUser(@RequestParam(name = "id") UUID id) {
        Optional<UserDto> odto = this.userServices.getUser(id);
        return odto.map(dto -> ResponseEntity.ok(this.userServices.dtoToOdto(dto))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}