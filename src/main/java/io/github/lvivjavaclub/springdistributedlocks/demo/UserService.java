package io.github.lvivjavaclub.springdistributedlocks.demo;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.locks.Lock;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  
  @PostConstruct
  public void setup() {
    log.info("===========================================================");
    log.info("User {}", userRepository.save(UserEntity.builder().balance(100L).build()));
  }

  @SneakyThrows(InterruptedException.class)
  public Optional<UserEntity> increaseBalance(Long id, Long add, Long sleep) {
    log.info("Increase balance for user {} by {}", id, add);

    
    final Optional<UserEntity> userEntityById = userRepository.findById(id);

    if (userEntityById.isPresent()) {
      final UserEntity userEntity = userEntityById.get();

      // One big part of the calculation.
      Thread.sleep(sleep);
      long newBalance = userEntity.getBalance() + add;

      userEntity.setBalance(newBalance);
      Optional<UserEntity> save = Optional.of(userRepository.save(userEntity));
      log.info("UserEntity {} ", save);

      return save;
    }

    return Optional.empty();
  }
}
