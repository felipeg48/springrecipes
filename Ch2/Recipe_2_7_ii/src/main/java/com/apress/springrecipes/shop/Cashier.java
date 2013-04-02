package com.apress.springrecipes.shop;

import java.io.IOException;

import org.springframework.context.MessageSource;

import java.util.Date;
import java.util.Locale;


public class Cashier {

    private MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
        
    public void checkout(ShoppingCart cart) throws IOException {
        String alert = messageSource.getMessage("alert.inventory.checkout",
						new Object[] { cart.getItems(), new Date() }, Locale.US);
        System.out.println(alert);
    }
}
