package com.minecave.social.storage;

import com.minecave.social.chat.channel.Channel;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

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
    private Set<UUID> friends, ignored;

    public SocialPlayer(UUID playerUUID){
        this.playerUUID = playerUUID;
        Player player = Bukkit.getPlayer(playerUUID);
        playerName = player.getName();

    }

}
