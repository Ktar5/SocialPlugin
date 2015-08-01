package com.minecave.social.chat.formatting;

import com.minecave.social.storage.SocialPlayer;

/**
 * Created by Carter on 7/31/2015.
 */
public class Format {

    private String format;


    public Format(String format){
        this.format = format;
    }

    public String getFormattedMessage(SocialPlayer sender){
        return format;
    }


}
