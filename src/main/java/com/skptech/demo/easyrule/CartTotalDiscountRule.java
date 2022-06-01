package com.skptech.demo.easyrule;

import com.skptech.demo.model.Cart;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "Cart Total Rule", description = "Give 10% off when shopping cart amount is greater than $200")
public class CartTotalDiscountRule {

    @Condition
    public boolean cartTotal(@Fact("cart") Cart cart) {
        return cart.isGreaterThanTwoHundred();
    }

    @Action
    public void giveDiscount(@Fact("cart") Cart cart) {
        cart.setTotalDiscount(200);
        cart.setEligibleForDiscount(true);
    }

}
