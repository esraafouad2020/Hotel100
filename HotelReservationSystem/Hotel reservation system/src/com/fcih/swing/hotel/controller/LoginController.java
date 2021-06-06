package com.fcih.swing.hotel.controller;

public interface LoginController {

    public abstract void login(Integer code, String password);

    public abstract boolean validData();
}
