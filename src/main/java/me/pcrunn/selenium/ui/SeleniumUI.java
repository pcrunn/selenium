package me.pcrunn.selenium.ui;

import me.pcrunn.selenium.impl.SimpleSeleniumService;
import me.pcrunn.selenium.ui.item.UIItem;
import me.pcrunn.selenium.util.Callback;
import org.bukkit.entity.Player;

import java.util.HashMap;

public interface SeleniumUI {

    /*
     * Returns the title of the ui;
     */

    String getTitle(Player player);


    /*
     * Returns a map of all the items and their slots;
     */

    HashMap<UIItem, Integer> getItems(Player player);


    /*
     * Returns the size of the UI;
     */

    int getSize(Player player);

    /*
     * Gets called when the menu closes;
     */

    Callback<Player> onClose();

    /*
     * Opens the menu for a player;
     */

    default void open(Player player){
        SimpleSeleniumService.getInstance().openUI(player, this);
    }
}
