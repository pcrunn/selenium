package me.pcrunn.selenium;

import me.pcrunn.selenium.ui.SeleniumUI;
import org.bukkit.entity.Player;


public interface SeleniumService {

    /*
     * Gets the open ui of a player.
     */

    SeleniumUI getOpenUI(Player player);

    /*
     * Opens a ui for a player.
     */

    void openUI(Player player, SeleniumUI ui);
}
