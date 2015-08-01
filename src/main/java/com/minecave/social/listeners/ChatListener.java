package com.minecave.social.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by Carter on 7/31/2015.
 */
public class ChatListener implements Listener {

    @EventHandler
    public void onchat(AsyncPlayerChatEvent event){
        event.setFormat("");
    }
}
