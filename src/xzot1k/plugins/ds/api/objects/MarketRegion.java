/*
 * Copyright (c) 2020 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.objects;

import org.bukkit.Location;

public interface MarketRegion {

    /**
     * Deletes the market region from the database, if found.
     *
     * @param async Whether the shop should be deleted on the main thread or not.
     */
    void delete(boolean async);

    boolean isInRegion(Location location);

    String getMarketId();

    Region getRegion();

}
