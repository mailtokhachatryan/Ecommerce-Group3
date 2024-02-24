package am.smartcode.ecommerce.service.card.impl;

import am.smartcode.ecommerce.feign.CardFeign;
import am.smartcode.ecommerce.model.dto.card.CardCreateDto;
import am.smartcode.ecommerce.model.dto.card.CardDto;
import am.smartcode.ecommerce.service.card.CardService;
import am.smartcode.ecommerce.util.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardFeign cardFeign;

    @Override
    public CardDto createCard(CardCreateDto cardCreateDto) {
        CardDto cardDto = new CardDto(cardCreateDto);
        cardDto.setUserId(CurrentUser.getId());
        return cardFeign.createCard(cardDto).getBody();
    }

    @Override
    public List<CardDto> getCards() {
        return cardFeign.getCardsByUserId(CurrentUser.getId()).getBody();
    }

    @Override
    public void deleteAllCards() {
        cardFeign.deleteAllCardsByUserId(CurrentUser.getId());
    }

    @Override
    public void deleteCardById(Integer id) {
        cardFeign.deleteCardById(id, CurrentUser.getId());
    }
}
