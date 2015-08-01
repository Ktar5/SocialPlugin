package com.minecave.social.chat.events;

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
        /*
           public static MessageFormat parseFormat(String format) {
        format = format.replace("{DISPLAYNAME}", "%1$s")
                .replace("{MESSAGE}", "%2$s")
                .replace("{GROUP}", "{0}")
                .replace("{WORLDNAME}", "{1}")
                .replace("{TEAMPREFIX}", "{2}")
                .replace("{TEAMSUFFIX}", "{3}")
                .replace("{TEAMNAME}", "{4}")
                .replace("{CHANNELPREFIX}", "{5}")
                .replaceAll("\\{factions_roleprefix[^}]*}","{6}")
                .replaceAll("\\{factions_name[^}]*}", "{7}")
                .replaceAll("(\\{[^0-9}]*})","'$1'");
        format = "§r".concat(format);
        format = ChatColor.translateAlternateColorCodes('&',format);

        return new MessageFormat(format);
    }
         */
    }
}
