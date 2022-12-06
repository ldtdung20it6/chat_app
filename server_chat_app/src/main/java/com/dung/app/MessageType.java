/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dung.app;

/**
 *
 * @author TRUNG DUNG
 */
public enum MessageType {
    TEXT(1), EMOJI(2), FILE(3), IMAGE(4);

    private final int value;

    public int getValue() {
        return value;
    }

    private MessageType(int value) {
        this.value = value;
    }

    public static MessageType toMessageType(int value) {
        if (value == 1) {
            return TEXT;
        } else if (value == 2) {
            return EMOJI;
        } else if (value == 3) {
            return FILE;
        } else {
            return IMAGE;
        }
    }
}