package com.skptech.demo;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;
import com.skptech.demo.model.*;
import com.skptech.demo.easyrule.HelloWorldRule;
import com.skptech.demo.easyrule.WeatherRule2;
import com.skptech.demo.easyrule.WeatherRule1;
import com.skptech.demo.openltablets.IRule;
import com.skptech.demo.rulebook.HelloWorldRuleBook;
import com.skptech.demo.rulebook.ShoppingCartRule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.openl.runtime.EngineFactory;

import java.net.URISyntaxException;
import java.util.Random;

@SpringBootApplication
public class RulesDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RulesDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(Rules rules, RulesEngine rulesEngine) {
        return args -> {
            System.out.println("-------------$$$$$$ Easy Rule $$$$$$-------------");
            executeEasyRule(rules, rulesEngine);

            System.out.println("-------------$$$$$$ Rule Book $$$$$$-------------");
            executeRuleBook();

            System.out.println("-------------$$$$$$ OpenL Tablets $$$$$$-------------");
            executeOpenLTablets();
        };
    }


    private void executeOpenLTablets() throws Exception {
        System.out.println("Still looking into....");
        /*
        User user = new User();
        user.setName("Sujit Paraseth");
        Case aCase = new Case();
        aCase.setUser(user);
        aCase.setHourOfDay(23);

        final EngineFactory<IRule> engineFactory = new RulesEngineFactory<IRule>(getClass().getClassLoader()
                .getResource("openltablets/HelloUser.xls"), IRule.class);
        IRule instance = engineFactory.newEngineInstance();
        instance.helloUser(aCase, new Response());
        */
    }


    private static void executeRuleBook() {
        HelloWorldRuleBook helloWorldRuleBook = new HelloWorldRuleBook();
        helloWorldRuleBook.defineHelloWorldRule().run(new FactMap<>());

        RuleBook cartPromotion = RuleBookBuilder.create(ShoppingCartRule.class).withResultType(Integer.class)
                .withDefaultResult(0)
                .build();
        NameValueReferableMap facts = new FactMap();
        Cart cart = new Cart(new Random().nextInt(5) + 1, 2000);
        facts.setValue("cart", cart);
        cartPromotion.run(facts);
        System.out.println("Price After Discount " + cart.getAmountAfterDiscount());
    }

    private static void executeEasyRule(Rules rules, RulesEngine rulesEngine) {
        //Create Facts

        //Plain String
        Facts helloFacts = new Facts();

        //Plain String
        Facts weatherFacts1 = new Facts();
        weatherFacts1.put("rain", true);

        //POJO Based
        Facts weatherFacts2 = new Facts();
        Weather weather = new Weather(true, "");
        weatherFacts2.put("weather", weather);

        //Create Rules
        rules.register(new HelloWorldRule());
        rules.register(new WeatherRule1());
        rules.register(new WeatherRule2());

        rulesEngine.fire(rules, helloFacts);
        rulesEngine.fire(rules, weatherFacts1);
        rulesEngine.fire(rules, weatherFacts2);
        System.out.println("Rules Output --> " + weather.getDescription());
    }

}
