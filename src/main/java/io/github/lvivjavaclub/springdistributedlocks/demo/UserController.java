package io.github.lvivjavaclub.springdistributedlocks.demo;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping(value = "/{id}/{add}/{sleep}")
  @ResponseBody
  public ResponseEntity<UserEntity> increaseBalance(
      @PathVariable("id") long id,
      @PathVariable("add") long add,
      @PathVariable("sleep") long sleep) {

    return userService.increaseBalance(id, add, sleep)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
