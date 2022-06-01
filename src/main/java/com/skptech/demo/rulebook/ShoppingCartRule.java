package com.skptech.demo.rulebook;

import com.deliveredtechnologies.rulebook.model.rulechain.cor.CoRRuleBook;
import com.deliveredtechnologies.rulebook.lang.RuleBuilder;
import com.skptech.demo.model.Cart;

public class ShoppingCartRule extends CoRRuleBook {

    @Override
    public void defineRules() {

        //give 10% off when cart total is greater than $200
        addRule(RuleBuilder.create().withFactType(Cart.class).withResultType(Integer.class)
                .when(facts -> facts.getOne().isGreaterThanTwoHundred())
                .then((facts, result) -> facts.getOne().setTotalDiscount(200))
                .stop()
                .build());
    }

}
