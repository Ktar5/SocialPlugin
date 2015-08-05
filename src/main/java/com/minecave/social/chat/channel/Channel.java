package com.minecave.social.chat.channel;

/**
 * Created by Carter on 7/31/2015.
 */

import com.minecave.social.Social;
import com.minecave.social.chat.filter.ColorFilter;
import com.minecave.social.chat.formatting.Format;
import com.minecave.social.storage.SocialPlayer;
import lombok.Getter;
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
    @Getter
    private final Set<UUID> listeners;
    @Getter
    private final Set<UUID> senders;
    private final boolean isPublic;

    /**
     * Construct a chat with all the nuts and bolts
     *
     * @param format Formatting for the chat chat
     * @param name Identifier of hte chat
     */
    public Channel(Format format, String name, boolean isPublic){
        this.format = format;
        this.isPublic = isPublic;
        this.name = name;
        listeners = senders = new HashSet<>();
    }

    public boolean canSpeak(Player player){
        return player.hasPermission(getSendPermission()) || isPublic;
    }

    public boolean canListen(Player player){
        return player.hasPermission(getReceivePermission()) || isPublic;
    }

    public boolean isPublic(){
        return isPublic;
    }

    /**
     * Sends a general, player-message to the chat.
     * IS checked for ips, links, etc. with permission nodes
     *
     * @param message The message to be sent.
     * @param sender  The message sender.
     */
    public void sendMessage(String message, Player sender){
        String finalMessage = ColorFilter.filter(sender, message);
        SocialPlayer player = Social.getInstance().getPlayerCoordinator().getPlayer(sender.getUniqueId());
        for(UUID uuid : members){
            SocialPlayer receiver = Social.getInstance().getPlayerCoordinator().getPlayer(uuid);
            if(!receiver.ignores(sender.getUniqueId())){

            }
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


