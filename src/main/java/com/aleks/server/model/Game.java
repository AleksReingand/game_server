package com.aleks.server.model;

import com.aleks.server.enums.GameStatus;
import com.aleks.server.enums.GameType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game extends AbstractEntity
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private int id;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
          name = "game_player",
          joinColumns = {@JoinColumn(name = "game_id")},
          inverseJoinColumns = {@JoinColumn(name = "player_id")}
  )
  private Set<Player> players;

  @Column(name = "deck_id", nullable = false)
  private int deckId;

  @Enumerated(EnumType.STRING)
  private GameType gameType;

  @Enumerated(EnumType.STRING)
  private GameStatus gameStatus;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
          name = "game_card",
          joinColumns = {@JoinColumn(name = "game_id")},
          inverseJoinColumns = {@JoinColumn(name = "card_id")}
  )
  private Set<Card> cards;
}
