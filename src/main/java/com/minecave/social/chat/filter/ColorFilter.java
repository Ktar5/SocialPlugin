package com.minecave.social.chat.filter;

import org.bukkit.entity.Player;

import java.util.regex.Pattern;

/**
 * Created by Carter on 8/1/2015.
 */
public class ColorFilter{

    //Vanilla patterns used to strip existing formats
    static final transient Pattern VANILLA_PATTERN = Pattern.compile("\u00a7+[0-9A-FK-ORa-fk-or]?");
    static final transient Pattern VANILLA_COLOR_PATTERN = Pattern.compile("\u00a7+[0-9A-Fa-f]");
    static final transient Pattern VANILLA_MAGIC_PATTERN = Pattern.compile("\u00a7+[Kk]");
    static final transient Pattern VANILLA_FORMAT_PATTERN = Pattern.compile("\u00a7+[L-ORl-or]");
    //'&' convention colour codes
    static final transient Pattern REPLACE_ALL_PATTERN = Pattern.compile("(?<!&)&([0-9a-fk-orA-FK-OR])");
    static final transient Pattern REPLACE_COLOR_PATTERN = Pattern.compile("(?<!&)&([0-9a-fA-F])");
    static final transient Pattern REPLACE_MAGIC_PATTERN = Pattern.compile("(?<!&)&([Kk])");
    static final transient Pattern REPLACE_FORMAT_PATTERN = Pattern.compile("(?<!&)&([l-orL-OR])");
    static final transient Pattern REPLACE_PATTERN = Pattern.compile("&&(?=[0-9a-fk-orA-FK-OR])");

    static final String permBase = "social.chat";

    public static String filter(Player player, String input) {
        if (input == null) {
            return null;
        }
        String message;
        if(player.hasPermission(permBase + ".color")){
            message = replaceColor(input, REPLACE_COLOR_PATTERN);
        }else{
            message = stripColor(input, VANILLA_COLOR_PATTERN);
        }
        if(player.hasPermission(permBase + ".magic")){
            message = replaceColor(message, REPLACE_MAGIC_PATTERN);
        } else {
            message = stripColor(message, VANILLA_MAGIC_PATTERN);
        }
        if (player.hasPermission(permBase + ".format")) {
            message = replaceColor(message, REPLACE_FORMAT_PATTERN);
        } else {
            message = stripColor(message, VANILLA_FORMAT_PATTERN);
        }
        return message;
    }

    public static String replaceColor(final String input, final Pattern pattern) {
        return REPLACE_PATTERN.matcher(pattern.matcher(input).replaceAll("\u00a7$1")).replaceAll("&");
    }

    static String stripColor(final String input, final Pattern pattern) {
        return pattern.matcher(input).replaceAll("");
    }

}
