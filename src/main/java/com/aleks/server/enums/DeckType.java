package com.aleks.server.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DeckType
{
    DECK_36(36), DECK_52(52);

    private final int deckAmount;
}
