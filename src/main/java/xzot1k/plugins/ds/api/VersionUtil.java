package xzot1k.plugins.ds.api;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface VersionUtil {

    void sendActionBar(@NotNull Player player, @NotNull String message);

    void displayParticle(@NotNull Player player, @NotNull String particleName, @NotNull Location location,
                         double offsetX, double offsetY, double offsetZ, int speed, int amount);

    /**
     * @param itemStack The item to obtain NBT from.
     * @param nbtTag    The NBT tag.
     * @return The value associated to the NBT tag on the item.
     */
    String getNBT(@NotNull ItemStack itemStack, @NotNull String nbtTag);

    /**
     * @param itemStack The item to update NBT on.
     * @param nbtTag    The NBT tag to update.
     * @param value     The value to associate with the NBT tag.
     * @return The finalized item.
     */
    ItemStack updateNBT(@NotNull ItemStack itemStack, @NotNull String nbtTag, @NotNull String value);

}
