package com.minecave.social.chat.formatting;

import java.util.regex.Pattern;

/**
 * Created by Carter on 7/31/2015.
 */
public enum FormatPart {
    PREFIX("{0}"),
    SUFFIX("{1}"),
    NAME("%1$s"),
    MESSAGE("%2$s");

    public String format;

    FormatPart(String s) {
        format = s;
    }

    public String var(){
        return "{" + this + "}";
    }

    public String quoted(){
        return Pattern.quote(var());
    }

}
