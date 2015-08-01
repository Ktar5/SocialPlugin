package com.minecave.social.chat.channel;

/**
 * Created by Carter on 7/31/2015.
 */

import com.minecave.social.chat.message.BroadcastMessage;
import com.minecave.social.chat.message.Message;
import com.minecave.social.chat.events.ChatSendEvent;
import com.minecave.social.chat.formatting.Format;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Carter on 5/2/2015.
 */
public class Channel {

    private final Format format;
    @Getter
    private final String name;
    private final Set<UUID> members;

    /**
     * Construct a chat with all the nuts and bolts
     *
     * @param format Formatting for the chat chat
     * @param name Identifier of hte chat
     */
    public Channel(Format format, String name){
        this.format = format;
        this.name = name;
        members = new HashSet<>();
    }

    /**
     * Add a player to the chat
     * Note: assumes permission checks already took place
     *
     * @param toAdd UUID of player to add to this listening chat
     */
    public void addPlayer(UUID toAdd){
        if(!members.contains(toAdd)){
            members.add(toAdd);
        }
    }

    public boolean isInChannel(UUID uuid){
        return members.contains(uuid);
    }

    public void removePlayer(UUID toRemove){
        if(members.contains(toRemove)){
            members.remove(toRemove);
        }
    }

    public boolean canSpeak(Player player){
        return player.hasPermission(getSendPermission());
    }

    public boolean canListen(Player player){
        return player.hasPermission(getReceivePermission());
    }

    /**
     * Sends a general, player-message to the chat.
     * IS checked for ips, links, etc. with permission nodes
     *
     * @param message The message to be sent.
     * @param sender  The message sender.
     */
    public void sendMessage(String message, Player sender){
        String finalMessage;
        Bukkit.getServer().getPluginManager().callEvent(new ChatSendEvent(new Message(finalMessage, sender), this));
        //TODO: listen to event and remove links, ips, chat colors, check for similarity
    }

    /**
     * Used to send a broadcast or array of messages. Formatting is not applied to a broadcast!
     * Broadcasted messages are not checked to remove links, ips, similarities, etc.. are
     * sent from "console"
     *
     * @param message An Array of Strings representing the body of the message
     */
    public void broadcastMessage(String[] message){
        Bukkit.getServer().getPluginManager().callEvent(new ChatSendEvent(new BroadcastMessage(message), this.getName()));
        for(String s : finalMessage){
        }
    }

    /**
     * Gets the permission node that is required for listening on this chat.
     *
     * @return The permission node that is required for listening on this chat.
     */
    public Permission getReceivePermission(){
        return new Permission("social.chat.receive." + getName().toLowerCase());
    }

    /**
     * Gets the permission node that is required for talking on this chat.
     *
     * @return The permission node that is required for talking on this chat.
     */
    public Permission getSendPermission(){
        return new Permission("social.chat.send." + getName().toLowerCase());
    }

}


