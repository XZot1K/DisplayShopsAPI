/*
 * Copyright (c) 2022 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import xzot1k.plugins.ds.api.enums.StageType;

public class ChatInteractionStageEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Player player;
    private StageType stageType;
    private String playerEntryValue;

    public ChatInteractionStageEvent(Player player, StageType stageType, String playerEntryValue) {
        setPlayer(player);
        setStageType(stageType);
        setPlayerEntryValue(playerEntryValue);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    // getters & setters
    public Player getPlayer() {
        return player;
    }

    private void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Returns the player's entry. Returns an empty string if the stage is of timeout.
     *
     * @return The player entry or empty string.
     */
    public String getPlayerEntryValue() {
        return playerEntryValue;
    }

    public void setPlayerEntryValue(String playerEntryValue) {
        this.playerEntryValue = playerEntryValue;
    }

    public StageType getStageType() {
        return stageType;
    }

    private void setStageType(StageType stageType) {
        this.stageType = stageType;
    }
}