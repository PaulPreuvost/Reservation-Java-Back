package com.gab1machine.fridge.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/storage")
@RestController
public class StorageController {

    private final StorageServices storageServices;

    @PostMapping
    public @ResponseBody StorageDto createStorage(@RequestBody StorageDto season) {
        return this.storageServices.createStorage(season);
    }
}