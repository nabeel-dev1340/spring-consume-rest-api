package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Todo(
    String title,
    boolean completed){
    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}