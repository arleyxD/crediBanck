package com.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @PostMapping("/enroll")
    public ResponseEntity<Card> enrollCard(@RequestParam String cardId) {
        Card enrolledCard = cardService.enrollCard(cardId);
        return ResponseEntity.ok(enrolledCard);
    }
    
    @DeleteMapping("/{cardId}")
    public ResponseEntity<Card> blockCard(@PathVariable String cardId) {
        Card blockedCard = cardService.blockCard(cardId);
        return ResponseEntity.ok(blockedCard);
    }
    
    @PostMapping("/balance")
    public ResponseEntity<Card> rechargeBalance(
            @RequestParam String cardId,
            @RequestParam double amount) {
        Card rechargedCard = cardService.rechargeBalance(cardId, amount);
        return ResponseEntity.ok(rechargedCard);
    }
    
    @GetMapping("/balance/{cardId}")
    public ResponseEntity<Double> checkBalance(@PathVariable String cardId) {
        double balance = cardService.checkBalance(cardId);
        return ResponseEntity.ok(balance);
    }
    
}
