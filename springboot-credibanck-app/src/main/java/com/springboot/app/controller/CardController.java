package com.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Card;
import com.springboot.app.service.CardService;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;
    

    //Generar número de tarjeta
    @GetMapping("/{productId}/number")
    public ResponseEntity<Card> generateCardNumber(@PathVariable String productId) {
        Card generatedCard = cardService.generateCardNumber(productId);
        return ResponseEntity.ok(generatedCard);
    }
}
