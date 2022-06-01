package com.skptech.demo.controller;

import com.skptech.demo.model.Cart;
import com.skptech.demo.service.CartTotalDiscountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discount")
public class CartTotalDiscountController {

    private final CartTotalDiscountService easyRuleService;

    public CartTotalDiscountController(CartTotalDiscountService easyRuleService) {
        this.easyRuleService = easyRuleService;
    }

    @GetMapping("/{cartTotal}")
    public Cart getCartTotalDiscount(@PathVariable("cartTotal") int cartTotal) {
        return easyRuleService.getCartTotalDiscount(cartTotal);
    }

}
