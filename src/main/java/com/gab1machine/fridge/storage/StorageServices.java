package com.gab1machine.fridge.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StorageServices {

    private final StorageRepository storageRepository;

    public StorageDto entityToDto(StorageEntity entity) {
        return new StorageDto(entity.getId(), entity.getDate(), entity.getSize());
    }

    public StorageDto createStorage(StorageDto storage) {
        /*if (this.storageRepository.existsByLabel(storage.label())) {
            throw new IllegalArgumentException("Storage already exists !");
        }*/
        UUID id = UUID.randomUUID();
        StorageEntity storageEntity = new StorageEntity();
        storageEntity.setId(id);
        storageEntity.setSize(storage.size());
        storageEntity.setDate(storage.date());
        StorageEntity savedStorage = this.storageRepository.save(storageEntity);
        return new StorageDto(savedStorage.getId(), savedStorage.getDate(), savedStorage.getSize());
    }

    public Optional<StorageDto> getStorage(UUID id) {
        Optional<StorageEntity> entity = this.storageRepository.findById(id);
        return entity.map(this::entityToDto);
    }

    public Optional<StorageEntity> getStorageEntity(UUID id) {
        return this.storageRepository.findById(id);
    }

    public boolean exist(UUID id) {
        return this.storageRepository.existsById(id);
    }
}