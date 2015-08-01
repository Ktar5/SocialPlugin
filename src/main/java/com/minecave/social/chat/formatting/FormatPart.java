package com.minecave.social.chat.formatting;

/**
 * Created by Carter on 7/31/2015.
 */
public enum FormatPart {
    PREFIX,
    SUFFIX,
    NAME,
    STRING,
    FRIEND_STATUS,
    NICKNAME;

    public String var(){
        return "{" + this + "}";
    }

}
