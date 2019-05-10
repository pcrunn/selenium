package me.pcrunn.selenium.ui.item;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class UIItem {

    private final ItemStack item;
    private final Consumer<Player> callback;

    public UIItem(ItemStack item, Consumer<Player> callback) {
        this.item = item;
        this.callback = callback;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public Consumer getCallback() {
        return this.callback;
    }

}
