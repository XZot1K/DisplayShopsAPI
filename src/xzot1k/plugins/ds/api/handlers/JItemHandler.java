/*
 * Copyright (c) 2020 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.handlers;

import org.bukkit.inventory.ItemStack;

public interface JItemHandler {

    /**
     * Gets an item as a JSON string.
     *
     * @param itemStack The item to get as a JSON.
     * @return The JSON string.
     */
    String getJsonItem(ItemStack itemStack);

}
