package com.skptech.demo.service;

import com.skptech.demo.model.Cart;
import com.skptech.demo.easyrule.CartTotalDiscountRule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CartTotalDiscountService {

    private final Facts facts;
    private final Rules rules;
    private final RulesEngine rulesEngine;

    public CartTotalDiscountService(Facts facts, Rules rules, RulesEngine rulesEngine) {
        this.facts = facts;
        this.rules = rules;
        this.rulesEngine = rulesEngine;
    }

    public Cart getCartTotalDiscount(int cartTotal) {
        Cart cart = new Cart(new Random().nextInt(5)+1, cartTotal);
        facts.put("cart", cart);
        rules.register(new CartTotalDiscountRule());
        rulesEngine.fire(rules, facts);
        return cart;
    }

}
