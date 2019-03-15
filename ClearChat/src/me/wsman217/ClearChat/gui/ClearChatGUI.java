package me.wsman217.ClearChat.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.wsman217.ClearChat.ClearChat;
import me.wsman217.ClearChat.Tools;

public class ClearChatGUI {

	ClearChat plugin;
	Tools tools;

	public ClearChatGUI(ClearChat plugin) {
		this.plugin = plugin;
		tools = plugin.tools;
	}

	public void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, plugin.getConfig().getInt("Settings.InventorySlots"),
				tools.color(plugin.getConfig().getString("Settings.GUIName")));
		
		Boolean already = false;

		if (tools.permCheck(p, "clearchat", false) && tools.permCheck(p, "clearmychat", false)) {
			List<String> clearChatLore = new ArrayList<String>();
			List<String> clearMyChatLore = new ArrayList<String>();

			ItemStack clearChat = new ItemStack(
					Material.matchMaterial(plugin.getConfig().getString("GUI.ClearChatItem.ItemType")), 1);
			ItemStack clearMyChat = new ItemStack(
					Material.matchMaterial(plugin.getConfig().getString("GUI.ClearMyChatItem.ItemType")), 1);

			for (String l : plugin.getConfig().getStringList("GUI.ClearChatItem.Lore")) {
				clearChatLore.add(tools.color(l));
			}
			for (String m : plugin.getConfig().getStringList("GUI.ClearMyChatItem.Lore")) {
				clearMyChatLore.add(tools.color(m));
			}

			ItemMeta ccm = clearChat.getItemMeta();
			ccm.setDisplayName(tools.color(plugin.getConfig().getString("GUI.ClearChatItem.ItemName")));
			ccm.setLore(clearChatLore);
			clearChat.setItemMeta(ccm);

			ItemMeta cmcm = clearMyChat.getItemMeta();
			cmcm.setDisplayName(tools.color(plugin.getConfig().getString("GUI.ClearMyChatItem.ItemName")));
			cmcm.setLore(clearMyChatLore);
			clearMyChat.setItemMeta(cmcm);

			inv.setItem(2, clearChat);
			inv.setItem(6, clearMyChat);
			already = true;
		}

		if (tools.permCheck(p, "clearchat", false) && already == false) {
			List<String> clearChatLore = new ArrayList<String>();

			ItemStack clearChat = new ItemStack(
					Material.matchMaterial(plugin.getConfig().getString("GUI.ClearChatItem.ItemType")), 1);

			for (String l : plugin.getConfig().getStringList("GUI.ClearChatItem.Lore")) {
				clearChatLore.add(tools.color(l));
			}

			ItemMeta ccm = clearChat.getItemMeta();
			ccm.setDisplayName(tools.color(plugin.getConfig().getString("GUI.ClearMyChatItem.ItemName")));
			ccm.setLore(clearChatLore);
			clearChat.setItemMeta(ccm);

			inv.setItem(4, clearChat);
		}

		if (tools.permCheck(p, "clearmychat", false) && already == false) {
			List<String> clearMyChatLore = new ArrayList<String>();

			ItemStack clearMyChat = new ItemStack(
					Material.matchMaterial(plugin.getConfig().getString("GUI.ClearMyChatItem.ItemType")), 1);

			for (String m : plugin.getConfig().getStringList("GUI.ClearMyChatItem.Lore")) {
				clearMyChatLore.add(tools.color(m));
			}

			ItemMeta cmcm = clearMyChat.getItemMeta();
			cmcm.setDisplayName(tools.color(plugin.getConfig().getString("GUI.ClearMyChatItem.ItemName")));
			cmcm.setLore(clearMyChatLore);
			clearMyChat.setItemMeta(cmcm);

			inv.setItem(4, clearMyChat);
		}

		p.openInventory(inv);
	}
}
