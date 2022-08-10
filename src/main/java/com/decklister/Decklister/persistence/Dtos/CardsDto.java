package com.decklister.Decklister.persistence.Dtos;

import com.decklister.Decklister.persistence.model.Card;
import lombok.Data;

import java.util.List;

@Data
public class CardsDto {
    private List<Card> cards;

    public void addCard(Card card) {
        this.cards.add(card);
    }
}
