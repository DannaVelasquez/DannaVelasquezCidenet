package com.cidenet.cidenet.Excepcions;

public class MessageError {

    private String type;
    private String message;

    public MessageError() {
    }

    public MessageError(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
