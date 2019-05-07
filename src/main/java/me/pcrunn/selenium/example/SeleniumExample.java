package me.pcrunn.selenium.example;

import me.pcrunn.selenium.SeleniumService;
import me.pcrunn.selenium.impl.SimpleSeleniumService;
import me.pcrunn.selenium.ui.SeleniumUI;
import me.pcrunn.selenium.ui.item.UIItem;
import me.pcrunn.selenium.util.Callback;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class SeleniumExample extends JavaPlugin {

    @Override
    public void onEnable() {
        SeleniumService service = new SimpleSeleniumService(this);

        Bukkit.getServer().getPluginManager().registerEvents(new Listener() {

            @EventHandler
            public void onInteract(PlayerInteractEvent event){
                if(!event.getAction().toString().toLowerCase().contains("right"))return;
                if(event.getItem().getType() != null && event.getItem().getType()== Material.DIAMOND);
                Player player = event.getPlayer();
                service.openUI(player, new SeleniumUI() {
                    @Override
                    public String getTitle(Player player) {
                        return "Hello World!";
                    }

                    @Override
                    public HashMap<UIItem, Integer> getItems(Player player) {
                        HashMap<UIItem, Integer> toReturn = new HashMap<>();
                        toReturn.put(new UIItem(new ItemStack(Material.DIAMOND_AXE), param /* Player */ -> {
                            param.closeInventory();
                            param.getWorld().generateTree(param.getLocation(), TreeType.BIRCH);
                            Location loc = param.getLocation();
                            loc.setY(loc.getBlockY()+10);
                            param.teleport(loc);
                        }), 3*9/2);
                        return toReturn;
                    }

                    @Override
                    public int getSize(Player player) {
                        return 3*9;
                    }

                    @Override
                    public Callback<Player> onClose() {
                        return param -> {};
                    }
                });
            }

        }, this);
    }
}