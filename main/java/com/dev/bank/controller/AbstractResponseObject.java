package com.dev.bank.controller;

import java.util.List;

public abstract class AbstractResponseObject <E> {
    private List<E> collection;
    private E model;
    private String value;
    private String status;
    private String message;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<E> getCollection() {
        return collection;
    }

    public void setCollection(List<E> collection) {
        this.collection = collection;
    }

    public E getModel() {
        return model;
    }

    public void setModel(E model) {
        this.model = model;
    }

    public String getStatus() {
        if (status == null) {
            status = "success";
        }
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
