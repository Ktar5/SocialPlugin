package com.minecave.social.chat.events;

import com.minecave.social.Social;
import com.minecave.social.chat.channel.Channel;
import com.minecave.social.chat.message.Message;
import com.minecave.social.chat.message.PlayerMessage;
import com.minecave.social.storage.SocialPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Carter on 7/31/2015.
 */
@Deprecated
public class ChatSendEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final String channel;
    private Message message;
    private boolean cancelled = false;

    /**
     * @param message The message object being sent
     * @param channel The channel that this is being sent to
     */
    public ChatSendEvent(Message message, String channel) {
        this.message = message;
        this.channel = channel;
    }

    /**
     * Gets the message sender, or null for console.
     *
     * @return The message sender, or null for console.
     */
    public SocialPlayer getSender() {
        if(this.message instanceof PlayerMessage){
            return ((PlayerMessage) this.message).getSocialPlayer();
        }
        return null;
    }

    /**
     * Gets the message to be sent.
     *
     * @return The message to be sent.
     */
    public Message getMessage() {
        return message;
    }

    /**
     * Sets the message to be sent.
     *
     * @param message The message to be sent.
     */
    public void setMessage(Message message) {
        this.message = message;
    }

    /**
     * Gets the {@link Channel} to which this message was sent.
     *
     * @return The {@link Channel}.
     */
    public Channel getChannel() {
        return Social.getInstance().getChannelCoordinator().getChannel(this.channel);
    }

    /**
     * Gets the handlers for the event.
     */
    @Override
    public HandlerList getHandlers() {
        return ChatSendEvent.handlers;
    }

    /**
     * Gets the handlers for the event.
     */
    public static HandlerList getHandlerList() {
        return ChatSendEvent.handlers;
    }

    /**
     * Gets the cancellation state of this event. A cancelled event will not be executed in the server, but will still
     * pass to other plugins
     *
     * @return true if this event is cancelled
     */
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    /**
     * Sets the cancellation state of this event. A cancelled event will not be executed in the server, but will still
     * pass to other plugins.
     *
     * @param cancel true if you wish to cancel this event
     */
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
