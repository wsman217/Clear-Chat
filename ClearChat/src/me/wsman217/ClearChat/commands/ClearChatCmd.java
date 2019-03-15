package me.wsman217.ClearChat.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import me.wsman217.ClearChat.ClearChat;
import me.wsman217.ClearChat.Tools;

public class ClearChatCmd implements CommandExecutor, TabCompleter {

	ClearChat plugin;
	Tools tools;

	public ClearChatCmd(ClearChat plugin) {
		this.plugin = plugin;
		tools = plugin.tools;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			if (args.length == 0) {
				tools.ClearChat();
				return true;
			} else {
				if (args[0].equalsIgnoreCase("reload")) {
					plugin.reloadConfig();
					sender.sendMessage(ChatColor.AQUA + "Config has been reloaded!");
					return true;
				}
				onHelp(sender, true);
				return true;
			}
		}
		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (args.length == 0) {
				if (tools.permCheck(p, "clearchat", true)) {
					tools.ClearChat();
					return true;
				}
			}

			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("reload")) {
					plugin.reloadConfig();
					p.sendMessage(ChatColor.AQUA + "Config has been reloaded!");
					return true;
				}
				if (tools.permCheck(p, "help", true)) {
					onHelp(sender, false);
					return true;
				}
			}
		}
		return false;
	}

	public void onHelp(CommandSender sender, boolean console) {
		if (console) {
			sender.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "Clear Chat Help Menu");
			sender.sendMessage(ChatColor.GOLD + "/ClearChat " + ChatColor.GREEN + "- Will clear the server chat!");
			sender.sendMessage(ChatColor.GOLD + "/ClearChat Help " + ChatColor.GREEN + "- Will open this help menu!");
			sender.sendMessage(
					ChatColor.GOLD + "/ClearChat Reload " + ChatColor.GREEN + "- Will reload the config.yml");
			sender.sendMessage(ChatColor.DARK_GRAY + "Created By: " + ChatColor.DARK_RED + "wsman217");
		}
		if (!console) {
			Player p = (Player) sender;
			p.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "Clear Chat Help Menu");
			if (tools.permCheck(p, "clearchat", false))
				p.sendMessage(ChatColor.GOLD + "/ClearChat " + ChatColor.GREEN + "- Will clear the server chat!");
			p.sendMessage(ChatColor.GOLD + "/ClearChat Help " + ChatColor.GREEN + "- Will open this help menu!");
			if (tools.permCheck(p, "clearmychat", false))
				p.sendMessage(ChatColor.GOLD + "/ClearMyChat " + ChatColor.GREEN + "- Will clear your personal chat!");
			if (tools.permCheck(p, "clearchatgui", false))
				p.sendMessage(ChatColor.GOLD + "/ClearChatGUI " + ChatColor.GREEN + "- Will open the clear chat gui!");
			if (tools.permCheck(p, "reload", false))
				p.sendMessage(ChatColor.GOLD + "/ClearChat Reload " + ChatColor.GREEN + "- Will reload the config.yml");
			p.sendMessage(ChatColor.DARK_GRAY + "Created By: " + ChatColor.DARK_RED + "wsman217");

		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (command.getName().equalsIgnoreCase("clearchat")) {
			if (args.length == 1) {
				List<String> arguments = new ArrayList<String>();
				
				if (!(sender instanceof Player)) {
				arguments.add("reload");
				arguments.add("help");
				}
				if (sender instanceof Player) {
					Player player = (Player)sender;
					if (tools.permCheck(player, "help", false))
							arguments.add("help");
					if (tools.permCheck(player, "reload", false))
						arguments.add("reload"); 
				}
				return arguments;
			}
		}
		
		return null;
	}
}
