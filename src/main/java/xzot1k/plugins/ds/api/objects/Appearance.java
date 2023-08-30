package xzot1k.plugins.ds.api.objects;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class Appearance implements Comparable<Appearance> {
    private static final List<Appearance> appearances = new ArrayList<>();
    private String id, material, permission;
    private List<String> requirement;
    private double price;

    public Appearance(@NotNull String id, @NotNull String material, double price, @Nullable String permission, @Nullable String... requirement) {
        setId(id);
        setMaterial(material);
        setPrice(price);
        setPermission(permission);
        setRequirement(new ArrayList<>(requirement.length));
    }

    public static void registerAppearance(@NotNull Appearance appearance) {
        if (!doesAppearanceExist(appearance.getId())) getAppearances().add(appearance);
    }

    public static Appearance getAppearance(@NotNull String id) {
        return getAppearances().parallelStream().filter(appearance -> appearance.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public static boolean doesAppearanceExist(@NotNull String id) {return (getAppearance(id) != null);}

    public static List<Appearance> getAppearances() {return appearances;}

    public ItemStack build(@NotNull Player player, @NotNull Shop shop) {return null;}

    public String getId() {return id;}

    public void setId(@NotNull String id) {this.id = id;}

    public String getMaterial() {return material;}

    public void setMaterial(@NotNull String material) {this.material = material;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public String getPermission() {return permission;}

    public void setPermission(@Nullable String permission) {this.permission = permission;}

    public List<String> getRequirement() {return requirement;}

    public void setRequirement(@NotNull List<String> requirement) {this.requirement = requirement;}
}
