package xzot1k.plugins.ds.api.eco;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class EcoHook {

    public abstract String getSingularName();

    public abstract String getPluralName();

    public abstract boolean deposit(@NotNull UUID playerUniqueId, double amount);

    public abstract boolean deposit(@NotNull OfflinePlayer player, double amount);

    public abstract boolean withdraw(@NotNull UUID playerUniqueId, double amount);

    public abstract boolean withdraw(@NotNull OfflinePlayer player, double amount);

    public abstract double getBalance(@NotNull UUID playerUniqueId);

    public abstract double getBalance(@NotNull OfflinePlayer player);

}
