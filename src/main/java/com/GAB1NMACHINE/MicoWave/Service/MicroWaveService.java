package com.GAB1NMACHINE.MicoWave.Service;

import com.GAB1NMACHINE.MicoWave.entity.MicroWave;
import repository.MicroWaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MicroWaveService {

    @Autowired
    private MicroWaveRepository microWaveRepository;

    public List<MicroWave> getAllMicroWaves() {
        return microWaveRepository.findAll();
    }

    public Optional<MicroWave> getMicroWaveById(Long id) {
        return microWaveRepository.findById(id);
    }

    public MicroWave saveMicroWave(MicroWave microWave) {
        return microWaveRepository.save(microWave);
    }

    public void deleteMicroWave(Long id) {
        microWaveRepository.deleteById(id);
    }
}
