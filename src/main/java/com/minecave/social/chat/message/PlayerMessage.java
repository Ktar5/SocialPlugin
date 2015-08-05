package com.minecave.social.chat.message;

import com.minecave.social.Social;
import com.minecave.social.storage.SocialPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Carter on 7/31/2015.
 */
@Deprecated
public class PlayerMessage extends Message {

    private final UUID sender;
    private final String message;

    public PlayerMessage(String message, UUID sender) {
        super();
        this.sender = sender;
        this.message = message;
    }

    public SocialPlayer getSocialPlayer(){
        return Social.getInstance().getPlayerCoordinator().getPlayer(this.sender);
    }

    public Player getPlayer(){
        return Bukkit.getPlayer(sender);
    }

    @Override
    public String serialize(){
        return this.time + "|" + message + "|" + sender.toString();
    }


}
