package me.pcrunn.selenium.ui.item;

import me.pcrunn.selenium.util.Callback;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class UIItem {

    private final ItemStack item;
    private final Callback<Player> callback;

    public UIItem(ItemStack item, Callback<Player> callback){
        this.item = item;
        this.callback = callback;
    }

    public ItemStack getItem(){return this.item;}
    public Callback getCallback(){return this.callback;}

}
