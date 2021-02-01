/*
 * Copyright (c) 2021 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import xzot1k.plugins.ds.api.enums.ItemType;
import xzot1k.plugins.ds.api.objects.Shop;

public class ShopItemSetEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final Shop shop;
    private final ItemType itemType;
    private ItemStack itemStack;
    private boolean cancelled;

    public ShopItemSetEvent(Player player, Shop shop, ItemType itemType, ItemStack handItemStack) {
        this.player = player;
        this.shop = shop;
        this.itemType = itemType;
        this.itemStack = handItemStack;
        setCancelled(false);
    }

    // getters & setters
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Player getPlayer() {
        return player;
    }

    public Shop getShop() {
        return shop;
    }

    public ItemType getItemType() {
        return itemType;
    }


    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

}