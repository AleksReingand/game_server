package com.aleks.server.model;

import com.aleks.server.enums.DescType;
import com.aleks.server.enums.GameStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private int id;

  @ManyToOne
  //@JoinColumn(name = "player_id", nullable = true)
  private List<Player> players;

  @Enumerated(EnumType.STRING)
  DescType deckType;

  @Enumerated(EnumType.STRING)
  GameStatus gameStatus;

  @Column(name = "created", nullable = false)
  private LocalDateTime created;
}
