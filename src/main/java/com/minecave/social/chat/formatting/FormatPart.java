package com.minecave.social.chat.formatting;

/**
 * Created by Carter on 7/31/2015.
 */
public enum FormatPart {
    PREFIX(null),
    SUFFIX(null),
    NAME("%1$s"),
    STRING(null),
    FRIEND_STATUS(null),
    MESSAGE("%2$s"),
    NICKNAME(null);

    public String format;

    FormatPart(String s) {
        if(s == null){
            format = var();
        }else{
            format = s;
        }
    }

    public String var(){
        return "{" + this + "}";
    }

}
