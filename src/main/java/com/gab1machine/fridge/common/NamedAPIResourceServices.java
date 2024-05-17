package com.gab1machine.fridge.common;

import com.gab1machine.fridge.storage.StorageDto;
import com.gab1machine.fridge.storage.StorageEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NamedAPIResourceServices {
    public NamedAPIResource<StorageEntity> storageResource(StorageEntity storageEntity) {
        return new NamedAPIResource<StorageEntity>("storage", storageEntity.getId() ,"/storage?id=" + storageEntity.getId().toString());
    }

    public NamedAPIResource<StorageEntity> storageResource(UUID id) {
        return new NamedAPIResource<StorageEntity>("storage", id ,"/storage?id=" + id.toString());
    }

}
