package com.minecave.social.storage;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Carter on 7/31/2015.
 */
public class ChannelSettings {

    @Getter
    @Setter
    private boolean alerted;
    @Getter
    @Setter
    private boolean active;

    public ChannelSettings(){
        alerted = false;
        active = false;
    }

}
