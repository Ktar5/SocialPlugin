package com.minecave.social.storage;

import com.minecave.social.Social;
import com.minecave.social.chat.channel.Channel;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * Created by Carter on 7/31/2015.
 */
public class SocialPlayer {

    @Getter
    private UUID playerUUID;
    @Getter
    private String playerName;
    @Getter
    private String nickname;
    private Map<String, ChannelSettings> channels; //all, including focused
    private Channel focused; //once theyre talking to
    @Getter
    private Set<UUID> friends, ignored;

    public SocialPlayer(UUID playerUUID){
        this.playerUUID = playerUUID;
        Player player = Bukkit.getPlayer(playerUUID);
        playerName = player.getName();
        friends = new HashSet<>();
        ignored = new HashSet<>();
        focused = Social.getInstance().getChannelCoordinator().getDefaultChannel();
        channels = new HashMap<>();
    }

    public void focus(Channel channel){
        focused = channel;
    }

    public boolean ignores(UUID uuid){
        return ignored.contains(uuid);
    }

    public boolean friended(UUID uuid){
        return friends.contains(uuid);
    }


}
