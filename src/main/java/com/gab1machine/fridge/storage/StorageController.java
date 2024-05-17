package com.gab1machine.fridge.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/storage")
@RestController
public class StorageController {

    private final StorageServices storageServices;

    @PostMapping
    public @ResponseBody StorageDto createStorage(@RequestBody StorageDto season) {
        return this.storageServices.createStorage(season);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<StorageDto> getStorage(@RequestParam(name = "id", required = true) UUID id) {
        Optional<StorageDto> dto = this.storageServices.getStorage(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}