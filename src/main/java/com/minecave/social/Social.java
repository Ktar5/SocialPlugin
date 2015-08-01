package com.minecave.social;

import com.minecave.social.chat.channel.ChannelCoordinator;
import com.minecave.social.storage.PlayerCoordinator;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Carter on 7/31/2015.
 */
public class Social extends JavaPlugin {

    @Getter
    private static Social instance = null;
    @Getter
    private PlayerCoordinator playerCoordinator = null;
    @Getter
    private ChannelCoordinator channelCoordinator = null;

    @Override
    public void onEnable(){
        instance = this;
    }

    @Override
    public void onDisable(){
        instance = null;
    }


}
