package me.wsman217.ClearChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.wsman217.ClearChat.commands.ClearChatCmd;
import me.wsman217.ClearChat.commands.ClearChatGUICmd;
import me.wsman217.ClearChat.commands.ClearMyChatCmd;
import me.wsman217.ClearChat.gui.ClearChatGUI;
import me.wsman217.ClearChat.listeners.ClearChatGUIListener;

public class ClearChat extends JavaPlugin {

	public Messages messages;
	public Tools tools;
	public ClearChatGUI ccg;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "ClearChat has been successfully disabled!");

		messages = new Messages(this);
		tools = new Tools(this);
		ccg = new ClearChatGUI(this);
		
		Bukkit.getPluginManager().registerEvents(new ClearChatGUIListener(this), this);	
		
		getCommand("clearchat").setExecutor(new ClearChatCmd(this));
		getCommand("clearmychat").setExecutor(new ClearMyChatCmd(this));
		getCommand("clearchatgui").setExecutor(new ClearChatGUICmd(this));

	}
	
	@Override
	public void onDisable() {
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "ClearChat has successfully disabled!");
	}
}
