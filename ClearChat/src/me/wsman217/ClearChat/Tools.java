package me.wsman217.ClearChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Tools {

	ClearChat plugin;

	public Tools(ClearChat plugin) {
		this.plugin = plugin;
	}

	public boolean permCheck(Player p, String perm, boolean SendMsg) {
		if (p.hasPermission("clearchat." + perm))
			return true;
		p.sendMessage(plugin.messages.NO_PERMS);
		return false;
	}

	public void ClearChat() {
		for (int x = 0; x < 150; x++) {
			Bukkit.broadcastMessage(plugin.messages.CLEAR_CHAT_MSG);
		}
	}

	public void ClearMyChat(Player p) {
		for (int x = 0; x < 150; x++) {
			p.sendMessage(plugin.messages.CLEAR_MY_CHAT_MSG);
		}
	}
	
	public String color(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
}
