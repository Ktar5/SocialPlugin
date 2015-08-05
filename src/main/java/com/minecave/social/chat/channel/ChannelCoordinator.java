package com.minecave.social.chat.channel;

import com.minecave.social.chat.formatting.Format;
import com.minecave.social.utils.CustomConfig;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carter on 7/31/2015.
 */
public class ChannelCoordinator {

    private Map<String, Channel> channels;
    private Map<String, String> shortcuts;

    public ChannelCoordinator(CustomConfig config){
        this.channels = new HashMap<>();
        for(String key : config.getConfig().getConfigurationSection("channels").getKeys(false)){
            ConfigurationSection section = config.getConfig().getConfigurationSection("channels." + key);
            channels.put(key.toLowerCase(), new Channel(
                    new Format(section.getString("format")),
                    key,
                    section.getBoolean("public")));
            shortcuts.put(section.getString("shortcut").toLowerCase(), key.toLowerCase());
        }
    }

    public Channel getChannel(String channel) {
        return channels.get(channel.toLowerCase());
    }

    public Channel getDefaultChannel() {
        return getChannel("default");
    }

}