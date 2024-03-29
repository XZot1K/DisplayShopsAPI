/*
 * Copyright (c) 2022 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.objects;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xzot1k.plugins.ds.api.enums.EconomyCallType;

import java.util.List;
import java.util.UUID;

public interface Shop {

    /**
     * Kills the shop's display packets entirely.
     *
     * @param player The player to send the destroy packets to.
     */
    void kill(@NotNull Player player);

    /**
     * Kills the shop's display packets entirely for ALL players.
     */
    void killAll();

    /**
     * Shows the shop display to the player.
     *
     * @param player        The player to show the display to.
     * @param showHolograms Whether the hologram lines are shown or not.
     */
    void display(@NotNull Player player, boolean showHolograms);

    /**
     * Checks if player is in range of this shop.
     *
     * @param player   The player to check.
     * @param distance The distance between the player and the shop.
     * @return Whether the player is in range or not.
     */
    boolean isInRange(@NotNull Player player, double distance);

    /**
     * Returns the shop's entire stored balance to the owner. If the owner does NOT exist, currency is sent to the passed player.
     */
    void returnBalance();

    /**
     * Drops the shop's entire stock onto the ground after calculating stacks.
     */
    void dropStock();

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
     * @param amount The amount for the {amount} placeholder.
     */
    void runCommands(@NotNull Player player, int amount);

    /**
     * Attempts to teleport the passed player to this shop.
     *
     * @param player The player to teleport.
     * @param charge Whether the player should be charged.
     */
    void visit(@NotNull Player player, boolean charge);

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
     * Updates the shop buy or sell time stamp (Used for the dynamic price changing system).
     * (Note: Only use BUY or SELL as the economy call type. Defaults to BUY if invalid or improper.)
     */
    void updateTransactionTimeStamp(@NotNull EconomyCallType economyCallType);

    /**
     * Checks if the shop is ready to be purged.
     *
     * @param purgeDuration The duration a shop must be untouched.
     * @return Whether it is ready.
     */
    boolean isReadyForPurge(int purgeDuration);

    /**
     * Checks if the shop is ready to have its dynamic price counter reset for either BUY or SELL.
     *
     * @param resetDuration   The duration a shop must go without a transaction in the BUY or SELL field.
     * @param economyCallType The type to check readiness for (Note: ONLY use BUY or SELL, by default BUY will be used).
     * @return Whether it is ready.
     */
    boolean isReadyForDynamicReset(int resetDuration, @NotNull EconomyCallType economyCallType);

    /**
     * Deletes the shop's data, deletes the base-block, drops the stock, destroys the display packet, and unregisters the object.
     *
     * @param async Whether the file deletion is async or not.
     */
    void purge(boolean async);

    /**
     * Gets the dynamic price that will be added/subtracted to the buy/sell price.
     *
     * @param originalPrice The original price.
     * @param isBuy         Determines whether the result will use buy or sell values.
     * @return The dynamic value that will
     */
    double getDynamicPriceValue(double originalPrice, boolean isBuy);

    /**
     * Checks to see if the player is able to edit the shop.
     *
     * @param player The player to check access for.
     * @return Whether the player can or can NOT edit the shop.
     */
    boolean canEdit(@NotNull Player player);

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

    void setShopId(@NotNull UUID shopId);

    int getBuyLimit();

    void setBuyLimit(int buyLimit);

    int getBuyCounter();

    void setBuyCounter(int buyCounter);

    /**
     * Obtains the balance of the shop which is used to purchase and store currency collected from invetors.
     *
     * @return The balance being held (currency).
     */
    double getStoredBalance();

    /**
     * Sets the balance of a shop. This balance is used to purchase and store currency collected from investors.
     *
     * @param amount The amount to set as the stored balance.
     */
    void setStoredBalance(double amount);

    boolean isCommandOnlyMode();

    void setCommandOnlyMode(boolean commandOnlyMode);

    List<String> getCommands();

    void setCommands(List<String> commands);

    List<UUID> getAssistants();

    int getShopItemAmount();

    void setShopItemAmount(int shopItemAmount);

    ItemStack getTradeItem();

    void setTradeItem(ItemStack tradeItem);

    long getChangeTimeStamp();

    void setChangeTimeStamp(long changeTimeStamp);

    long getLastBuyTimeStamp();

    void setLastBuyTimeStamp(long buyTimeStamp);

    long getLastSellTimeStamp();

    void setLastSellTimeStamp(long sellTimeStamp);

    int getSellLimit();

    void setSellLimit(int sellLimit);

    int getSellCounter();

    void setSellCounter(int sellCounter);

    String getDescription();

    void setDescription(String description);

    String getStoredBaseBlockMaterial();

    void setStoredBaseBlockMaterial(String storedBaseBlockMaterial);

    boolean canDynamicPriceChange();

    void setDynamicPriceChange(boolean dynamicPriceChange);

    int getDynamicBuyCounter();

    void setDynamicBuyCounter(int dynamicPriceCounter);

    int getDynamicSellCounter();

    void setDynamicSellCounter(int dynamicPriceCounter);

    /**
     * Gets  the player unique ID of whom is currently editing the shop.
     *
     * @return The current editor's unique ID.
     */
    UUID getCurrentEditor();

    /**
     * Sets the current editor.
     *
     * @param currentEditor The unique ID of the player editing.
     */
    void setCurrentEditor(@Nullable UUID currentEditor);

    /**
     * Resets the shop entirely. The time stamp is also updated.
     */
    void reset();

    /**
     * @return Gets the visit item icon for the visit shop menu.
     */
    ItemStack getVisitItemIcon();

    /**
     * Sets the visit item icon for the visit shop menu.
     *
     * @param visitItemIcon The new icon item.
     */
    void setVisitItemIcon(ItemStack visitItemIcon);

}