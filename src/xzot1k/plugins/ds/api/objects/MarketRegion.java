/*
 * Copyright (c) 2021 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface MarketRegion {

    /**
     * Resets the region clearing rents and extra data.
     */
    void reset();

    /**
     * Resets a shop within the market region to a non-rented form.
     *
     * @param shop The shop to reset.
     */
    void resetHelper(Shop shop);

    /**
     * Updates the rented time stamp to the current system time.
     */
    void updateRentedTimeStamp();

    /**
     * Attempts to perform an economy transaction alongside extend the rent expire duration (Returns true or false based on economy transaction success).
     *
     * @param player The player to charge.
     * @return Whether the transaction succeeded.
     */
    boolean extendRent(Player player);

    /**
     * Attempts to perform an economy transaction alongside rent the market region (Returns true or false based on economy transaction success).
     *
     * @param player The player to charge.
     * @return Whether the transaction succeeded.
     */
    boolean rent(Player player);

    /**
     * Obtains remaining time until the market region rent expires.
     *
     * @return The time until expire (in seconds).
     */
    int timeUntilExpire();

    /**
     * Obtains remaining time until the market region rent expires in string format.
     *
     * @return The nicely formatted remaining time.
     */
    String formattedTimeUntilExpire();

    /**
     * Deletes the market region from the database, if found.
     *
     * @param async Whether the shop should be deleted on the main thread or not.
     */
    void delete(boolean async);

    /**
     * Checks if the passed location is located within the market region.
     *
     * @param location The location to check for.
     * @return Whether the location is contained.
     */
    boolean isInRegion(Location location);

    /**
     * Checks if the passed location is located within the market region.
     *
     * @param location The location to check for.
     * @return Whether the location is contained.
     */
    boolean isInRegion(LocationClone location);

    String getMarketId();

    Region getRegion();

    /**
     * Gets the current region renter (Returns NULL if no renter is found).
     *
     * @return The current renter (can be NULL).
     */
    UUID getRenter();

    /**
     * Sets the renter of the region.
     *
     * @param renter The new renter unique ID.
     */
    void setRenter(UUID renter);

    /**
     * Gets the exact date and time when the renter began renting the region.
     *
     * @return The time stamp created.
     */
    String getRentedTimeStamp();

    /**
     * Sets the rented time stamp.
     *
     * @param rentedTimeStamp The time stamp in the format "yyyy.MM.dd.HH.mm.ss".
     */
    void setRentedTimeStamp(String rentedTimeStamp);

    /**
     * Gets the duration extension add to the rent expire time (in seconds).
     *
     * @return The rent expire extension duration (in seconds).
     */
    int getExtendedDuration();

    /**
     * Sets the duration extension add to the rent expire time (in seconds).
     *
     * @param extendedDuration The duration to set.
     */
    void setExtendedDuration(int extendedDuration);

}
