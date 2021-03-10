package com.aleks.server.controller;

import com.aleks.server.DTO.PlayerDto;
import com.aleks.server.model.Player;
import com.aleks.server.services.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
@Slf4j
public class PlayerController
{
  @Autowired
  PlayerService playerService;

  @PostMapping("/create")
  public ResponseEntity<Player> createPlayer(@RequestBody PlayerDto playerDto)
  {
    log.info("created");
    return null;
  }
}
