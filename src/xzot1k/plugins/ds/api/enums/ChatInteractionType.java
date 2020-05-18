/*
 * Copyright (c) 2020 XZot1K, All rights reserved.
 */

package xzot1k.plugins.ds.api.enums;

public enum ChatInteractionType {
    SHOP_ITEM_AMOUNT("change-item-amount"), BUY_LIMIT("buy-limit"), SELL_LIMIT("sell-limit"), BUY_PRICE("change-buy-price"),
    SELL_PRICE("change-sell-price"), WITHDRAW_STOCK("withdraw-stock"), DEPOSIT_STOCK("deposit-stock"), EDIT_DESCRIPTION("edit-description"),
    DEPOSIT_BALANCE("deposit-balance"), WITHDRAW_BALANCE("withdraw-balance");

    String interactionId;

    ChatInteractionType(String interactionId) {
        this.interactionId = interactionId;
    }

    public String getInteractionId() {
        return interactionId;
    }
}
