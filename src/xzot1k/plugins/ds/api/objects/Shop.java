/*
 * Copyright (c) 2020 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.objects;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

public interface Shop {

    /**
     * Kills the shop's display packets entirely.
     *
     * @param player The player to send the destroy packets to.
     */
    void kill(Player player);

    /**
     * Shows the shop display to the player.
     *
     * @param player        The player to show the display to.
     * @param showHolograms Whether the hologram lines are shown or not.
     */
    void display(Player player, boolean showHolograms);

    /**
     * Checks if player is in range of this shop.
     *
     * @param player   The player to check.
     * @param distance The distance between the player and the shop.
     * @return Whether the player is in range or not.
     */
    boolean isInRange(Player player, double distance);

    /**
     * Drops the shop's entire stock onto the ground after calculating stacks.
     */
    void dropStock(Player player);

    /**
     * Saves the shop to the database.
     *
     * @param async Whether it should be saved on the main thread or not.
     */
    void save(boolean async);

    /**
     * Runs all commands given to the shop.
     *
     * @param player the player used inside the commands.
     */
    void runCommands(Player player);

    /**
     * Deletes the shop from the database if found.
     *
     * @param async Whether the shop should be deleted on the main thread or not.
     */
    void delete(boolean async);

    /**
     * Registers the shop into the manager.
     */
    void register();

    /**
     * Unregisters the shop from the manager.
     */
    void unRegister();

    /**
     * Gets if a shop is an admin shop or not.
     *
     * @return Whether the shop is admin or not.
     */
    boolean isAdminShop();

    /**
     * Sets the owner to null to initiate admin shop mode.
     */
    void makeAdminShop();

    /**
     * Updates the shop change time stamp (Used for the purge system).
     */
    void updateTimeStamp();

    /**
     * Checks if the shop is ready to be purged.
     *
     * @param purgeDuration The duration a shop must be untouched.
     * @return Whether it is ready or not.
     */
    boolean isReadyForPurge(int purgeDuration);

    /**
     * Deletes the shop's data, deletes the base-block, drops the stock, destroys the display packet, and unregisters the object.
     *
     * @param player The player to drop items to.
     * @param async  Whether the file deletion is async or not.
     */
    void purge(Player player, boolean async);

    /**
     * Gets the dynamic price that will be added/subtracted to the buy/sell price.
     *
     * @param originalPrice The original price.
     * @param isBuy         Determines whether the result will use buy or sell values.
     * @return The dynamic value that will
     */
    double getDynamicPriceValue(double originalPrice, boolean isBuy);

    // getters & setters
    ItemStack getShopItem();

    void setShopItem(ItemStack shopItem);

    /**
     * Gets the shop's unit buy price.
     *
     * @param useDynamicPricing Whether to apply dynamic price values to the base value or not.
     * @return The total result.
     */
    double getBuyPrice(boolean useDynamicPricing);

    void setBuyPrice(double buyPrice);

    /**
     * Gets the shop's unit sell price.
     *
     * @param useDynamicPricing Whether to apply dynamic price values to the base value or not.
     * @return The total result.
     */
    double getSellPrice(boolean useDynamicPricing);

    void setSellPrice(double sellPrice);

    UUID getOwnerUniqueId();

    void setOwnerUniqueId(UUID ownerUniqueId);

    LocationClone getBaseLocation();

    void setBaseLocation(LocationClone baseLocation);

    int getStock();

    void setStock(int stock);

    UUID getShopId();

    void setShopId(UUID shopId);

    int getBuyLimit();

    void setBuyLimit(int buyLimit);

    int getBuyCounter();

    void setBuyCounter(int buyCounter);

    /**
     * This is where the physical currency obtained by the shop is stored, until retrieved.
     *
     * @return The currency being held.
     */
    int getPhysicalCurrencyStock();

    void setPhysicalCurrencyStock(int physicalCurrencyStock);

    boolean isCommandOnlyMode();

    void setCommandOnlyMode(boolean commandOnlyMode);

    List<String> getCommands();

    void setCommands(List<String> commands);

    int getShopItemAmount();

    void setShopItemAmount(int shopItemAmount);

    ItemStack getTradeItem();

    void setTradeItem(ItemStack tradeItem);

    String getChangeTimeStamp();

    void setChangeTimeStamp(String changeTimeStamp);

    int getSellLimit();

    void setSellLimit(int sellLimit);

    int getSellCounter();

    void setSellCounter(int sellCounter);

    String getDescription();

    void setDescription(String description);

    String getInitialBaseBlockMaterial();

    void setInitialBaseBlockMaterial(String initialBaseBlockMaterial);

    boolean canDynamicPriceChange();

    void setDynamicPriceChange(boolean dynamicPriceChange);

    int getDynamicPriceCounter();

    void setDynamicPriceCounter(int dynamicPriceCounter);

}
