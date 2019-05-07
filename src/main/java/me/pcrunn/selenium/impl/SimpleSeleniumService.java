package me.pcrunn.selenium.impl;

import me.pcrunn.selenium.SeleniumService;
import me.pcrunn.selenium.ui.SeleniumUI;
import me.pcrunn.selenium.ui.event.UIListener;
import me.pcrunn.selenium.ui.item.UIItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class SimpleSeleniumService implements SeleniumService {

    private static SimpleSeleniumService instance;

    private final JavaPlugin plugin;
    private HashMap<Player, SeleniumUI> players;

    public SimpleSeleniumService(JavaPlugin plugin){
        instance = this;

        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(new UIListener(), plugin);
        this.players = new HashMap<>();
    }

    public static SimpleSeleniumService getInstance() {
        return instance;
    }

    @Override
    public SeleniumUI getOpenUI(Player player) {
        return players.get(player);
    }

    @Override
    public void openUI(Player player, SeleniumUI ui) {
        int size = ui.getSize(player);
        HashMap<UIItem, Integer> items = ui.getItems(player);
        String title = ui.getTitle(player);

        Inventory inv = Bukkit.createInventory(player, size, title);

        items.forEach((item, slot)-> inv.setItem(slot, item.getItem()));

        player.openInventory(inv);
        players.put(player, ui);
    }
}
