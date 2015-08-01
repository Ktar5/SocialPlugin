package com.minecave.social.chat.filter;

import java.util.regex.Pattern;

/**
 * Created by Carter on 8/1/2015.
 */
public class AdvertListener {
    //Used to prepare xmpp output
    static final transient Pattern LOGCOLOR_PATTERN = Pattern.compile("\\x1B\\[([0-9]{1,2}(;[0-9]{1,2})?)?[m|K]");

    static final transient Pattern URL_PATTERN = Pattern.compile("((?:(?:https?)://)?[\\w-_\\.]{2,})\\.([a-zA-Z]{2,3}(?:/\\S+)?)");

    public static String blockURL(final String input)
    {
        if (input == null)
        {
            return null;
        }
        String text = URL_PATTERN.matcher(input).replaceAll("$1 $2");
        while (URL_PATTERN.matcher(text).find())
        {
            text = URL_PATTERN.matcher(text).replaceAll("$1 $2");
        }
        return text;
    }

}
