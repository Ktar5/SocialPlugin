package com.minecave.social.storage;

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
    private Map<String, ChannelSettings> channels;
    private Set<UUID> friends, ignored;

    public SocialPlayer(UUID playerUUID){
        this.playerUUID = playerUUID;
        Player player = Bukkit.getPlayer(playerUUID);
        playerName = player.getName();

    }

}
