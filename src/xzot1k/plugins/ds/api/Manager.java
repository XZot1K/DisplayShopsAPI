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
import org.bukkit.util.Vector;
import xzot1k.plugins.ds.api.enums.ChatInteractionType;
import xzot1k.plugins.ds.api.events.EconomyCallEvent;
import xzot1k.plugins.ds.api.events.EconomyCallType;
import xzot1k.plugins.ds.api.handlers.ActionBarHandler;
import xzot1k.plugins.ds.api.handlers.ParticleHandler;
import xzot1k.plugins.ds.api.handlers.SerializeUtil;
import xzot1k.plugins.ds.api.objects.DataPack;
import xzot1k.plugins.ds.api.objects.MarketRegion;
import xzot1k.plugins.ds.api.objects.Shop;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface Manager {

    /**
     * Loads the passed player's data pack. If not found, a new data pack module is created.  (CAN RETURN NULL)
     *
     * @param player The player to load the data pack for.
     */
    DataPack loadDataPack(Player player);

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
     * Sends a color translated message to the players as either a normal chat message or action bar message.
     *
     * @param player  The player to send the message to.
     * @param message The message to send (color codes accepted, if the message contains {bar} at the front it will be sent to the action bar).
     */
    void sendMessage(Player player, String message);

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
     * Gets the min buy or sell price of a selected material.
     *
     * @param material The material to check for.
     * @param isBuy    Whether it is buy or sell.
     * @return The found minimum.
     */
    double getMaterialMinPrice(Material material, boolean isBuy);

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
     * @return a long value for the ID.
     */
    UUID generateNewId();

    /**
     * Gets the proper offsets based on configuration or defaults.
     *
     * @param shop The shop to obtain the offsets for.
     * @return The array of X, Y, and Z offsets.
     */
    Double[] getBaseBlockOffsets(Shop shop);

    /**
     * Attempts to get a shop object from the shop map by its ID.
     *
     * @param shopId The ID to get the shop from
     * @return the shop object.
     */
    Shop getShopById(UUID shopId);

    /**
     * Get a shop from the passed chest if possible.
     *
     * @param location Chest location.
     * @return The shop if found.
     */
    Shop getShop(Location location);

    /**
     * Attempts to load all available shops from the database.
     *
     * @param isAsync   Whether the task is ran on the main thread.
     * @param tableName The table where the data is located in the database.
     */
    void loadShops(boolean isAsync, String tableName);

    /**
     * Checks to see if the material is blocked or not.
     *
     * @param material The material to check for.
     * @return The result.
     */
    boolean isBlockedMaterial(Material material);

    /**
     * Saves all market regions to the database.
     *
     * @param statement The SQL statement required to save.
     */
    void saveMarketRegions(Statement statement);

    /**
     * Loads all market regions into the memory.
     */
    void loadMarketRegions();

    /**
     * Obtains the default base material without checking attached durability.
     *
     * @return The material type.
     */
    Material getBaseBlockType();

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
     * Gets the shop limit of the passed player.
     *
     * @param player The player to check for.
     * @return The limit they have on shops.
     */
    int getShopLimit(Player player);

    /**
     * Obtains the passed shop's max stock based on owner permissions or administrator bypasses.
     *
     * @param shop The shop to get the max stock for (obtains owner for permissions, returns max possible integer if the shop is admin or the owner has the "displayshops.stock.max").
     * @return The obtained max stock (defaults to configuration value or max possible integer, if the shop is admin).
     */
    int getMaxStock(Shop shop);

    /**
     * Gets the player specific shop promotion item modifier.
     *
     * @param player The player to check.
     * @return The modifier for multiplication.
     */
    double getPromotionPriceModifier(Player player);

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
     * Gets the base-block selection GUI and calculates the player's access, current shop base-block, etc.
     *
     * @param player The player to use for permission basing.
     * @param shop   The shop to use to get information from.
     * @return The complete GUI.
     */
    Inventory getBaseBlockSelectionMenu(Player player, Shop shop);

    /**
     * Builds and sets the shop edit menu from the configuration to the variable.
     *
     * @param player The player the edit menu needs to be built for.
     * @return The built inventory.
     */
    Inventory buildShopEditMenu(Player player);


    /**
     * Builds and sets the shop transaction menu from the configuration to the variable.
     *
     * @param player The player to personalize the menu for.
     * @param shop   The shop the interactions should be made for.
     */
    Inventory buildTransactionMenu(Player player, Shop shop);

    /**
     * Updates the transaction gui with live information.
     *
     * @param inventory The inventory to update.
     * @param shop      The shop to use the information from.
     * @parm player The player to personalize the menu for.
     */
    void updateTransactionMenu(Inventory inventory, Player player, Shop shop, int unitCount);

    /**
     * Checks if the passed world is in the world blacklist.
     *
     * @param world The world to check for.
     * @return Whether the world is blocked or not.
     */
    boolean isBlockedWorld(World world);

    /**
     * Obtains the currency balance of the passed player.
     *
     * @param player   The player to get the balance of.
     * @param shop     The shop to get the trade-item from.
     * @param useVault Whether or not to use Vault methods.
     * @return The found player balance amount.
     */
    double getCurrencyBalance(Player player, Shop shop, boolean useVault);

    // getters & setters
    HashMap<UUID, Shop> getShopMap();

    ParticleHandler getParticleHandler();

    ActionBarHandler getActionBarHandler();

    SerializeUtil getSerializeUtil();

    List<MarketRegion> getMarketRegions();

    SimpleDateFormat getDateFormat();

    HashMap<UUID, DataPack> getDataPackMap();
}
