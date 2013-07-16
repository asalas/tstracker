package com.cloudfoundry.tstracker.support.messages;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * @author
 * asalas
 */
public class MessagesReader implements Serializable {

    private static final long serialVersionUID = 1L;
    private static MessagesReader instance = new MessagesReader();
    private ResourceBundle resourceBundle;

    private MessagesReader() {
        resourceBundle = ResourceBundle.getBundle("i18n/textMessages");
    }

    public static MessagesReader getInstance() {
        return instance;
    }

    public String getString(String key) {
        try {
            return resourceBundle.getString(key);
        } catch (MissingResourceException e) {
            return "¡¡¡" + key + "!!!";
        }
    }

    public String getString(String key, Object... params) {
        try {
            return MessageFormat.format(resourceBundle.getString(key), params);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}