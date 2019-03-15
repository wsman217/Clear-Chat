package me.wsman217.ClearChat;

import org.bukkit.ChatColor;

public class Messages {

	
	public final String CLEAR_CHAT_MSG, CLEAR_MY_CHAT_MSG, NO_PERMS, PLAYER_ONLY;
	
	public Messages(ClearChat plugin) {
		CLEAR_CHAT_MSG = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.ClearChatMsg"));
		CLEAR_MY_CHAT_MSG = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.ClearMyChatMsg"));
		NO_PERMS = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.NoPerms"));
		PLAYER_ONLY = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.PlayersOnly"));
	}
}
