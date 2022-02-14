/*
 * Copyright (c) 2022 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.handlers;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface ParticleHandler {
    void displayParticle(Player player, String particleName, Location location, double offsetX, double offsetY, double offsetZ, int speed, int amount);
}