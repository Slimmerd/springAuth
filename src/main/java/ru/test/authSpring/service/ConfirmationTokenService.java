package ru.test.authSpring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.authSpring.entity.ConfirmationTokenEntity;
import ru.test.authSpring.repository.ConfirmationTokenRepo;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

     private final ConfirmationTokenRepo confirmationTokenRepo;

     public void saveConfirmationToke(ConfirmationTokenEntity token){
         confirmationTokenRepo.save(token);
     }

    public Optional<ConfirmationTokenEntity> getToken(String token) {
        return confirmationTokenRepo.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepo.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
