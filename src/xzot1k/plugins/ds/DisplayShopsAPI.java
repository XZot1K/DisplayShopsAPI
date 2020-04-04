/*
 * Copyright (c) 2020 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds;

import com.sun.istack.internal.NotNull;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xzot1k.plugins.ds.api.Manager;
import xzot1k.plugins.ds.api.handlers.DisplayPacket;
import xzot1k.plugins.ds.api.objects.Shop;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

interface DisplayShopsAPI {

    /**
     * Logs a message with a level to the console under the DisplayShops title.
     *
     * @param level   Level of the message.
     * @param message The message to log.
     */
    void log(Level level, String message);

    /**
     * Sets up all tasks; however, it doesn't cancel or stop existing tasks.
     */
    void setupTasks();

    /**
     * Syncs all block materials to their defined shops.
     */
    void syncBaseBlocks();

    /**
     * Gets latest version text from Spigot.
     *
     * @return The version number on the page.
     */
    String getLatestVersion();

    // custom configurations

    /**
     * Reloads all configs associated with DisplayShops.
     */
    void reloadConfigs();

    /**
     * Gets the language file configuration.
     *
     * @return The FileConfiguration found.
     */
    FileConfiguration getLangConfig();

    /**
     * Gets the menus file configuration.
     *
     * @return The FileConfiguration found.
     */
    FileConfiguration getMenusConfig();

    /**
     * Saves the default configuration files (Doesn't replace existing).
     */
    void saveDefaultConfigs();

    // packet methods

    /**
     * Gets the display packet a player currently has made for a specific shop (Can return NULL).
     *
     * @param shop   The shop to check for.
     * @param player The player to check for.
     * @return the display packet instance for the shop.
     */
    DisplayPacket getDisplayPacket(Shop shop, Player player);

    /**
     * Clears all display packets for a player on file.
     *
     * @param player The player to remove the packets for.
     */
    void clearDisplayPackets(Player player);

    /**
     * Un-registers the existing display packet for a specific shop from the player.
     *
     * @param shop   The shop to look for.
     * @param player The player to look for.
     */
    void removeDisplayPacket(Shop shop, Player player);

    /**
     * Updates the display packet for a specific shop for the player.
     *
     * @param shop          The shop to use.
     * @param player        The player to set it for.
     * @param displayPacket The packet to set for the shop.
     */
    void updateDisplayPacket(Shop shop, Player player, DisplayPacket displayPacket);

    /**
     * Sends the entire display to the player. In specific, it will kill existing packets on the MAIN THREAD and create new packets ON ANOTHER THREAD (Async).
     * (NOTE: The 'showHolograms' parameter will be ignored if the 'always-display' is enabled)
     *
     * @param shop          The shop to create the display for.
     * @param player        The player to send the display packets to.
     * @param showHolograms Whether holograms above the glass and item are visible/created.
     */
    void sendDisplayPacket(@NotNull Shop shop, @NotNull Player player, boolean showHolograms);

    /**
     * Sends the entire display to all players in the area. In specific, it will kill existing packets on the MAIN THREAD and create new packets ON ANOTHER THREAD (Async).
     * (NOTE: The 'showHolograms' parameter will be ignored if the 'always-display' is enabled)
     *
     * @param shop          The shop to create the display for.
     * @param showHolograms Whether holograms above the glass and item are visible/created.
     */
    void sendDisplayPacketToAll(@NotNull Shop shop, boolean showHolograms);

    /**
     * Sends the entire display to the player (ALL SHOPS). In specific, it will kill existing packets on the MAIN THREAD and create new packets ON ANOTHER THREAD (Async).
     * (NOTE: The 'showHolograms' parameter will be ignored if the 'always-display' is enabled)
     *
     * @param player        The player to send the display packets to.
     * @param showHolograms Whether holograms above the glass and item are visible/created.
     */
    void sendPossibleDisplayPackets(@NotNull Player player, boolean showHolograms);

    // getters & setters

    /**
     * Returns the manager where most data and API methods are stored.
     *
     * @return The manager class.
     */
    Manager getManager();

    /**
     * Returns the server version.
     *
     * @return Server version.
     */
    String getServerVersion();

    boolean isOffHandVersion();

    HashMap<UUID, UUID> getShopMemory();

    Connection getDatabaseConnection();

    int getAutoSaveTaskId();

    void setAutoSaveTaskId(int autoSaveTaskId);

    int getShopSyncTaskId();

    void setShopSyncTaskId(int shopSyncTaskId);

    int getInSightTask();

    void setInSightTask(int inSightTask);

    HashMap<UUID, String> getChunkCoordMap();

    List<UUID> getPacketReceivedDelayedPlayers();

    List<UUID> getTeleportingPlayers();

}
