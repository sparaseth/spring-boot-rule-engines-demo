package com.skptech.demo.rulebook;

import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;

public class HelloWorldRuleBook {

    public RuleBook<Object> defineHelloWorldRule() {
        return RuleBookBuilder.create()
                .addRule(rule -> rule.withNoSpecifiedFactType()
                        .then(f -> System.out.println("Hello "))
                )
                .addRule(rule -> rule.withNoSpecifiedFactType()
                        .then(f -> System.out.println("World"))
                )
                .build();
    }
}
