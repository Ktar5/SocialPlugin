package com.minecave.social.chat.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Carter on 7/31/2015.
 */
@Deprecated
public class BroadcastMessage extends Message{

    private List<String> message;

    /**
     * Create a broadcasted/console message object using
     * a list of strings
     *
     * @param message
     */
    public BroadcastMessage(List<String> message){
        this.message = message;
    }

    /**
     * Create a broadcasted/console message object using
     * an array of strings
     *
     * @param message
     */
    public BroadcastMessage(String[] message){
        this(new ArrayList<String>(Arrays.asList(message)));
    }

    @Override
    public String serialize() {
        return null;//TODO
    }
}
