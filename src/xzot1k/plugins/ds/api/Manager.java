/*
 * Copyright (c) 2020 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import xzot1k.plugins.ds.api.enums.ChatInteractionType;
import xzot1k.plugins.ds.api.events.EconomyCallEvent;
import xzot1k.plugins.ds.api.events.EconomyCallType;
import xzot1k.plugins.ds.api.handlers.ActionBarHandler;
import xzot1k.plugins.ds.api.handlers.JItemHandler;
import xzot1k.plugins.ds.api.handlers.ParticleHandler;
import xzot1k.plugins.ds.api.objects.MarketRegion;
import xzot1k.plugins.ds.api.objects.Region;
import xzot1k.plugins.ds.api.objects.Shop;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface Manager {

    /**
     * Ray traces from the provided vectors to obtain a shop from the locations it passes through.
     *
     * @param worldName       The world to ray trace in.
     * @param eyeVector       The eye location of the entity or just the general origin location.
     * @param directionVector The direction at which the vector should go.
     * @param distance        The distance at which the ray should travel.
     * @return The found shop, returns NULL if NOT found.
     */
    Shop getShopRayTraced(String worldName, Vector eyeVector, Vector directionVector, double distance);

    /**
     * Initiates a withdraw/deposit transaction directed at an investor and owner automating messages, taxing, and more (The stopInTacks() method must be called still).
     *
     * @param investor        The buyer.
     * @param producer        The seller.
     * @param shop            The shop in use.
     * @param economyCallType The economy type being processed Buy, Sell, etc.
     * @param price           The price in use.
     * @return the economy call event
     */
    EconomyCallEvent initiateShopEconomyTransaction(Player investor, OfflinePlayer producer, Shop shop, EconomyCallType economyCallType, double price);

    /**
     * Runs the chat interaction operation as normal using the given parameters.
     *
     * @param player           The player of who is in the chat interaction.
     * @param playerEntryValue The value/message the player entered.
     */
    void initiateChatInteractionOperation(Player player, ChatInteractionType chatInteractionType, String playerEntryValue);

    /**
     * Gives itemstack to player 'X' amount of times at a specific unit count (stack count)
     *
     * @param player    the player to give items to.
     * @param itemStack the itemstack to give.
     * @param amount    the amount of items.
     * @param unitCount the unit count (stack count).
     */
    void giveItem(Player player, ItemStack itemStack, int amount, int unitCount);

    /**
     * Updates the cooldown id for the passed player.
     *
     * @param player     The player to update the cooldown for.
     * @param cooldownId The cooldown id to update.
     */
    void updateCooldown(Player player, String cooldownId);

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
    long getCooldown(Player player, String cooldownId, int cooldown);

    /**
     * Retrieve a market region, if the passed location is inside it.
     *
     * @param location The location to check.
     * @return The MarketRegion object found.
     */
    MarketRegion isInMarketRegion(Location location);

    /**
     * Retrieve a market region by Id, if it exists.
     *
     * @param marketId The id to check for.
     * @return The MarketRegion object.
     */
    MarketRegion getMarketRegion(String marketId);

    /**
     * Checks if a market region already exists with the passed id.
     *
     * @param marketId The id to check.
     * @return The result as a boolean value.
     */
    boolean doesMarketRegionExist(String marketId);

    /**
     * Gets if a location is too close to a shop based on the distance value in the configuration.
     *
     * @param location The location to check around.
     * @return The result as a boolean.
     */
    boolean isTooClose(Location location);

    /**
     * Gets the name of the item. If the item name is not custom, then either the original or translated name will be used.
     *
     * @param itemStack The item to get the name of.
     * @return The item name.
     */
    String getItemName(ItemStack itemStack);

    /**
     * Obtains any translation created for the passed material found in the "lang.yml".
     *
     * @param material The material to obtain the translation for.
     * @return The translated version.
     */
    String getTranslatedName(Material material);

    /**
     * Obtains any translation created for the passed enchantment found in the "lang.yml".
     *
     * @param enchantment The enchantment to obtain the translation for.
     * @return The translated version.
     */
    String getTranslatedName(Enchantment enchantment);

    /**
     * Obtains any translation created for the passed potion type found in the "translation.yml".
     *
     * @param potionType The potion type to obtain the translation for.
     * @return The translated version.
     */
    String getTranslatedName(PotionType potionType);

    /**
     * Gets the names of the enchantments and formats them into a neat format.
     *
     * @param itemStack The item to get the enchants from.
     * @return The new formatted line.
     */
    String getEnchantmentLine(ItemStack itemStack);

    /**
     * Gets the names of the potion effects and formats them into a neat format.
     *
     * @param itemStack The item to get the potion effects from.
     * @return The new formatted line.
     */
    String getPotionLine(ItemStack itemStack);

    /**
     * Gets roman numeral value from 1 - 10.
     *
     * @param number The number between 1 and 10.
     * @return The roman numeral.
     */
    String getRomanNumeral(int number);

    /**
     * Colors the text passed.
     *
     * @param message The message to translate.
     * @return The colored text.
     */
    String color(String message);

    /**
     * Formats a given number based on the locale.
     *
     * @param value     The numerical value.
     * @param isDecimal Whether the number contains a decimal.
     * @return The formatted number as a string.
     */
    String formatNumber(double value, boolean isDecimal);

    /**
     * Gets the max buy or sell price of a selected material.
     *
     * @param material The material to check for.
     * @param isBuy    Whether it is buy or sell.
     * @return The found maximum.
     */
    double getMaterialMaxPrice(Material material, boolean isBuy);

    /**
     * Checks if a shop already exists with the passed id.
     *
     * @param shopId The id to check for.
     * @return Whether the id exists in true or false format.
     */
    boolean doesShopIdExist(UUID shopId);

    /**
     * Generates a new ID suited for a new display shop.
     *
     * @return a long value for the id.
     */
    UUID generateNewId();

    /**
     * Get a shop from the passed chest if possible.
     *
     * @param location Chest location.
     * @return The shop if found.
     */
    Shop getShop(Location location);

    /**
     * Loads all shops from the database and creates a backup.
     */
    void loadShops(boolean isAsync);

    /**
     * Checks to see if the material is blocked or not.
     *
     * @param material The material to check for.
     * @return The result.
     */
    boolean isBlockedMaterial(Material material);

    /**
     * Saves all market regions to the database.
     */
    void saveMarketRegions();

    /**
     * Loads all market regions into the memory.
     */
    void loadMarketRegions();

    /**
     * This method grabs the first permission based base-block material the player can have for a shop.
     *
     * @param player The player to check permissions of.
     * @return The found material with a backup default of CHEST.
     */
    Material getBaseBlockMaterial(Player player);

    /**
     * Returns a list of all shops owned by the player.
     *
     * @param player The player to check for.
     * @return The list of shops the player owns.
     */
    List<Shop> getPlayerShops(Player player);

    /**
     * Gets if the player has reached the maximum amount of warps they can have.
     *
     * @param player The player to check.
     * @return Whether the player has exceeded their limit or not.
     */
    boolean exceededShopLimit(Player player);

    /**
     * Gives the passed item stack to the player the passed amount of times in the form of stacks.
     *
     * @param player           The player to give the items to (drops at feet if inventory is full).
     * @param itemStackToClone The item stack to make the stacks from.
     * @param amount           The amount of the items to give to the player (NOT stacks).
     */
    void giveItemStacks(Player player, ItemStack itemStackToClone, int amount);

    /**
     * Remove a certain amount of a certain similar item.
     *
     * @param inventory The inventory to remove from.
     * @param itemStack The item to check for.
     * @param amount    The amount to remove.
     * @return Whether an item was removed or not.
     */
    boolean removeItem(Inventory inventory, ItemStack itemStack, int amount);

    /**
     * Get amount of similar items.
     *
     * @param inventory The inventory to check.
     * @param itemStack The item to check for.
     * @return The total amount.
     */
    int getItemAmount(Inventory inventory, ItemStack itemStack);

    /**
     * Checks if two items are identical using string format.
     *
     * @param itemOne The first item.
     * @param itemTwo The second item.
     * @return Whether the items are identical.
     */
    boolean isSimilar(ItemStack itemOne, ItemStack itemTwo);

    /**
     * See if a string is NOT a numerical value.
     *
     * @param string The string to check.
     * @return Whether it is numerical or not.
     */
    boolean isNotNumeric(String string);

    /**
     * Wraps a string into multiple lines based on a word count.
     *
     * @param text          The long string to wrap.
     * @param wordLineLimit The line size in terms of word count.
     * @return wraps the string to multiple lines
     */
    List<String> wrapString(String text, int wordLineLimit);

    /**
     * Builds and returns the shop creation item.
     *
     * @param player The player to check for what base-block to use.
     * @param amount The amount of the item stack.
     * @return The shop creation physical item stack.
     */
    ItemStack buildShopCreationItem(Player player, int amount);

    /**
     * Builds and returns the shop currency item.
     *
     * @param amount The amount of the item stack.
     * @return The shop currency physical item stack.
     */
    ItemStack buildShopCurrencyItem(int amount);

    /**
     * Builds and sets the shop edit menu from the configuration to the variable.
     */
    void buildShopEditMenu();

    /**
     * Builds and sets the shop transaction menu from the configuration to the variable.
     */
    Inventory buildTransactionMenu(Shop shop);

    /**
     * Updates the transaction gui with live information.
     *
     * @param inventory The inventory to update.
     * @param shop      The shop to use the information from.
     */
    void updateTransactionMenu(Inventory inventory, Shop shop, int unitCount);

    /**
     * Checks if the passed world is in the world blacklist.
     *
     * @param world The world to check for.
     * @return Whether the world is blocked or not.
     */
    boolean isBlockedWorld(World world);

    /**
     * Updates player's personal chat task values.
     *
     * @param player The player to update.
     */
    void updatePersonalChatTask(Player player);

    // getters & setters
    HashMap<UUID, Shop> getShopMap();

    HashMap<UUID, Shop> getShopInteractionMap();

    HashMap<UUID, String> getChatInteractionMap();

    ParticleHandler getParticleHandler();

    JItemHandler getJItemHandler();

    ActionBarHandler getActionBarHandler();

    Inventory getShopEditMenu();

    List<MarketRegion> getMarketRegions();

    HashMap<UUID, Region> getRegionSelectionMap();

    List<UUID> getSelectionModePlayers();

    SimpleDateFormat getDateFormat();

    HashMap<UUID, BukkitTask> getPersonalChatTasks();

}
