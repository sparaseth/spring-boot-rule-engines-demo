package com.skptech.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Response {

    private String result;
    private Map<String, String> map = new HashMap<String, String>();

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
