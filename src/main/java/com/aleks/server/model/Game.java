package com.aleks.server.model;

import com.aleks.server.enums.DeckType;
import com.aleks.server.enums.GameStatus;
import com.aleks.server.enums.GameType;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private int id;

  @ManyToOne
  @JoinColumn(name = "first_player_id", nullable = false)
  private Player firstPlayer;

  @ManyToOne
  @JoinColumn(name = "second_player_id", nullable = true)
  private Player secondPlayer;

  @Enumerated(EnumType.STRING)
  DeckType deckType;

  @Enumerated(EnumType.STRING)
  private GameType gameType;

  @Enumerated(EnumType.STRING)
  GameStatus gameStatus;

  @Column(name = "created", nullable = false)
  private LocalDateTime created;
}
