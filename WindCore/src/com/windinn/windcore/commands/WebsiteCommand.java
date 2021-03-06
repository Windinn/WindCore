package com.windinn.windcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.windinn.windcore.WindCore;

public class WebsiteCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		JavaPlugin plugin = JavaPlugin.getPlugin(WindCore.class);

		if (sender instanceof Player) {
			Player player = (Player) sender;
			player.sendMessage(
					ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.website.message",
							"&bWindCore&f: The website of the server is < insert URL in config >")));
		}

		return false;
	}

}
