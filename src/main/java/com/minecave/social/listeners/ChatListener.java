package com.minecave.social.listeners;

import com.minecave.social.Social;
import com.minecave.social.storage.SocialPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by Carter on 7/31/2015.
 */
public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        SocialPlayer player = Social.getInstance().getPlayerCoordinator().getPlayer(event.getPlayer().getUniqueId());
        if(){

        }



        for(player.){

        }
    }
}
