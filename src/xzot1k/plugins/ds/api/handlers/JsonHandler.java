/*
 * Copyright (c) 2020 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.handlers;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface JsonHandler {

    void sendJsonMessage(Player player, String JsonString);

    String getJsonItem(ItemStack itemStack);

}
