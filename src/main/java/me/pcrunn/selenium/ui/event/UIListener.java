package me.pcrunn.selenium.ui.event;

import me.pcrunn.selenium.impl.SimpleSeleniumService;
import me.pcrunn.selenium.ui.SeleniumUI;
import me.pcrunn.selenium.ui.item.UIItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class UIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(!(event.getWhoClicked() instanceof Player))return;
        Player player = (Player) event.getWhoClicked();
        SeleniumUI ui = SimpleSeleniumService.getInstance().getOpenUI(player);
        if(ui == null)return;

        UIItem item = ui.getItems(player).entrySet().stream().filter(entry -> entry.getValue() == event.getSlot()).findFirst().orElse(null).getKey();
        if(item == null)return;
        event.setCancelled(true);
        item.getCallback().call(player);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){
        if(!(event.getPlayer() instanceof Player))return;
        Player player = (Player) event.getPlayer();
        SeleniumUI ui = SimpleSeleniumService.getInstance().getOpenUI(player);

        if(ui == null)return;
        ui.onClose().call(player);
    }

}
