package com.gab1machine.fridge.common;

import com.gab1machine.fridge.storage.StorageDto;
import com.gab1machine.fridge.storage.StorageEntity;
import org.springframework.stereotype.Service;

@Service
public class NamedAPIResourceServices {
    public NamedAPIResource storageResource(StorageEntity storageEntity) {
        return new NamedAPIResource("storage", storageEntity.getId() ,"/storage?id=" + storageEntity.getId().toString());
    }
}
