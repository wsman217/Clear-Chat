package me.wsman217.ClearChat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.wsman217.ClearChat.ClearChat;
import me.wsman217.ClearChat.Tools;

public class ClearMyChatCmd implements CommandExecutor {

	ClearChat plugin;
	Tools tools;

	public ClearMyChatCmd(ClearChat plugin) {
		this.plugin = plugin;
		tools = plugin.tools;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(plugin.messages.PLAYER_ONLY);
			return true;
		}
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if (tools.permCheck(p, "clearmychat", true)) {
				tools.ClearMyChat(p);
				return true;
			}
		}
		return false;
	}
}
