package me.wsman217.ClearChat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.wsman217.ClearChat.ClearChat;
import me.wsman217.ClearChat.Tools;

public class ClearChatGUICmd implements CommandExecutor {

	ClearChat plugin;
	Tools tools;

	public ClearChatGUICmd(ClearChat plugin) {
		this.plugin = plugin;
		tools = plugin.tools;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(plugin.messages.PLAYER_ONLY);
			return true;
		}
		System.out.println("Outside of if");
		if (sender instanceof Player) {
			Player p = (Player) sender;
			System.out.println("Its a player");
			if (tools.permCheck(p, "clearchatgui", true)) {
				System.out.println("They have perms");
				plugin.ccg.openGUI(p);
				return true;
			}
		}
		return false;
	}

}
