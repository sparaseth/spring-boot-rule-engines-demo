package com.skptech.demo.easyrule;

import com.skptech.demo.model.Weather;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule
public class WeatherRule2 {

    @Condition
    public boolean cartTotal(@Fact("weather") Weather weather) {
        return weather.isRain();
    }

    @Action
    public void giveDiscount(@Fact("weather") Weather weather) {
        weather.setDescription("Hollla.....It rains, take an umbrella!");
    }

}
