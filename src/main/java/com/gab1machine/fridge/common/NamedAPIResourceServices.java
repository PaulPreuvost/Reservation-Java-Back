package com.gab1machine.fridge.common;

import com.gab1machine.fridge.storage.StorageDto;
import org.springframework.stereotype.Service;

@Service
public class NamedAPIResourceServices {
    public NamedAPIResource storageResource(StorageDto storage) {
        return new NamedAPIResource("storage", storage.id() ,"/storage?id=" + storage.id().toString());
    }
}
