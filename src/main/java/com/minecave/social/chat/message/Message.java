package com.minecave.social.chat.message;

import lombok.Getter;

/**
 * Created by Carter on 7/31/2015.
 */
public abstract class Message {
    @Getter
    public long time;

    public Message(){
        this.time = System.currentTimeMillis();
    }

    public abstract String serialize();
}
