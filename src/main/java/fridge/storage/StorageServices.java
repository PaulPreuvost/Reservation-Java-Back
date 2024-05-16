package fridge.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StorageServices {

    private final StorageRepository storageRepository;

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
}