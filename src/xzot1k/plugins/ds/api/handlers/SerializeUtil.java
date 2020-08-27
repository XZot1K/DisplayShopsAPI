/*
 * Copyright (c) 2020 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.handlers;

import org.bukkit.inventory.ItemStack;

public interface SerializeUtil {

    /**
     * Convert an item to a string including all NBT.
     *
     * @param itemStack The item to serialize.
     * @return The serialized string.
     */
    String toString(ItemStack itemStack);

    /**
     * Convert a string back into an item including all NBT.
     *
     * @param itemString The serialized item string.
     * @return The itemstack object.
     */
    ItemStack toItem(String itemString);

}
