package me.wsman217.ClearChat.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.wsman217.ClearChat.ClearChat;
import me.wsman217.ClearChat.Tools;

public class ClearChatGUIListener implements Listener {

	ClearChat plugin;
	Tools tools;

	public ClearChatGUIListener(ClearChat plugin) {
		this.plugin = plugin;
		tools = plugin.tools;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getInventory();
		ItemStack item = e.getCurrentItem();
		ItemMeta itemMeta = null;
		String itemName = null;
		if (item != null) {
			itemMeta = item.getItemMeta();
			itemName = itemMeta.getDisplayName();
		}
		if (inv == null)
			return;
		if (inv.getName().equals(tools.color(plugin.getConfig().getString("Settings.GUIName")))) {
			e.setCancelled(true);

			System.out.println(itemName);
			if (itemName.equals(tools.color(plugin.getConfig().getString("GUI.ClearChatItem.ItemName")))) {
				tools.ClearChat();
				p.sendMessage(ChatColor.DARK_GRAY + "Server chat has been cleared");
				p.closeInventory();
				return;
			}

			if (itemName.equals(tools.color(plugin.getConfig().getString("GUI.ClearMyChatItem.ItemName")))) {
				tools.ClearMyChat(p);
				p.sendMessage(ChatColor.DARK_GRAY + "Your chat has been cleared");
				p.closeInventory();
				return;
			}

			p.closeInventory();
		}

	}
}
