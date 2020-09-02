/*
 * Copyright (c) 2020 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.objects;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import xzot1k.plugins.ds.api.enums.ChatInteractionType;

import java.util.HashMap;

public interface DataPack {

    /**
     * Updates player's personal chat task values by cancelling the previous and cancelling the new after a configurable duration.
     */
    void updatePersonalChatTask();

    /**
     * Updates the cooldown id for the player.
     *
     * @param cooldownId The cooldown id to update.
     */
    void updateCooldown(String cooldownId);

    /**
     * Checks if the passed player has a cooldown at the specified id based on the base cooldown value.
     *
     * @param player     The player to check.
     * @param cooldownId The cooldown id.
     * @param cooldown   The cooldown's amount (normally the configuration value).
     * @return Whether the cooldown is active (above zero).
     */
    boolean isOnCooldown(Player player, String cooldownId, int cooldown);

    /**
     * Gets the cooldown left for the player at a specified id.
     *
     * @param player     The player to get the cooldown from.
     * @param cooldownId The cooldown id.
     * @param cooldown   The cooldown value (Usually from configuration).
     * @return The cooldown time remaining.
     */
    int getCooldown(Player player, String cooldownId, int cooldown);

    /**
     * Checks to see if the player has purchased and unlocked the base block material.
     *
     * @param unlockId The material followed by a colon and its durability which is normally set to -1 or 0.
     * @return Whether the appearance is unlocked.
     */
    boolean hasUnlockedBBM(String unlockId);

    /**
     * Toggles a base block appearance from locked to unlocked and vice versa.
     *
     * @param unlockId The material followed by a colon and the durability.
     */
    void toggleBBMLock(String unlockId);

    /**
     * Updates all base-block data to either locked aside the default or unlock all.
     *
     * @param unlockAll Whether or not to unlock all materials.
     */
    void updateAllBaseBlockAccess(boolean unlockAll);

    /**
     * Obtains a full string of cooldowns applied to the player.
     *
     * @return The string full of cooldowns.
     */
    String cooldownsToString();

    // getters & setters
    String getBaseBlockUnlocks();

    void setBaseBlockUnlocks(String baseBlockUnlocks);

    /**
     * Gets the shop object the player is currently tethered to from editing or any similar actions.
     *
     * @return The shop object. (Returns NULL if there is no shop selected for editing or similar actions)
     */
    Shop getSelectedShop();

    /**
     * Sets the shop object the player is currently editing or any similar actions.
     *
     * @param selectedShop The shop object to set as.
     */
    void setSelectedShop(Shop selectedShop);

    /**
     * Gets the current chat interaction type in-progress. This is what is used to define what
     * the player's entry is being used for.
     *
     * @return The chat interaction type. (Returns NULL if no chat interaction is active)
     */
    ChatInteractionType getChatInteractionType();

    /**
     * Sets the chat interaction identification type.
     *
     * @param chatInteractionType The type to set as.
     */
    void setChatInteractionType(ChatInteractionType chatInteractionType);

    /**
     * Obtains the selected region of a player, if there is one.
     *
     * @return The region object. (Returns NULL if no region is selected)
     */
    Region getSelectedRegion();

    /**
     * Sets the selected region stored for the player.
     *
     * @param selectedRegion The new region object.
     */
    void setSelectedRegion(Region selectedRegion);

    /**
     * Checks if the player is currently in region selection mode.
     *
     * @return Whether the player is in selection mode.
     */
    boolean isInSelectionMode();

    /**
     * Sets if the player is in selection mode or not.
     *
     * @param inSelectionMode Whether the player should be in selection mode or not.
     */
    void setInSelectionMode(boolean inSelectionMode);

    BukkitTask getCurrentChatTask();

    void setCurrentChatTask(BukkitTask currentChatTask);

    HashMap<String, Long> getCooldownMap();

}
