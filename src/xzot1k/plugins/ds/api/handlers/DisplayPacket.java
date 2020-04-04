/*
 * Copyright (c) 2020 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.handlers;

import org.bukkit.entity.Player;

import java.util.Collection;

public interface DisplayPacket {

    Collection<Integer> getEntityIds();

    void hide(Player player);

}
