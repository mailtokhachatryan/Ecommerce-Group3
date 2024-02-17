package am.smartcode.ecommerce.service.card;


import am.smartcode.ecommerce.model.dto.card.CardDto;

import java.util.List;

public interface CardService {

    CardDto createCard(CardDto cardDto);

    List<CardDto> getCardByUserId(Integer userId);

    void deleteCardsByUserId(Integer userId);

    void deleteCardById(Integer id);

}
