package am.smartcode.ecommerce.service.card;


import am.smartcode.ecommerce.model.dto.card.CardCreateDto;
import am.smartcode.ecommerce.model.dto.card.CardDto;

import java.util.List;

public interface CardService {

    CardDto createCard(CardCreateDto cardDto);

    List<CardDto> getCards();

    void deleteAllCards();

    void deleteCardById(Integer id);

}
