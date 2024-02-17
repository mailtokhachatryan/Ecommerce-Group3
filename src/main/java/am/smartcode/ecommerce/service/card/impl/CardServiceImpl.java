package am.smartcode.ecommerce.service.card.impl;

import am.smartcode.ecommerce.feign.CardFeign;
import am.smartcode.ecommerce.model.dto.card.CardDto;
import am.smartcode.ecommerce.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardFeign cardFeign;

    @Override
    public CardDto createCard(CardDto cardDto) {
        return cardFeign.createCard(cardDto).getBody();
    }

    @Override
    public List<CardDto> getCardByUserId(Integer userId) {
        return cardFeign.getCardsByUserId(userId).getBody();
    }

    @Override
    public void deleteCardsByUserId(Integer userId) {
        cardFeign.deleteAllCardsByUserId(userId);
    }

    @Override
    public void deleteCardById(Integer userId) {
        cardFeign.deleteCardByUserId(userId);
    }
}
