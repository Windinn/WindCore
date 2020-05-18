package com.windinn.windcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.windinn.windcore.WindCore;

public class ClearchatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		JavaPlugin plugin = JavaPlugin.getPlugin(WindCore.class);

		if (sender instanceof Player) {
			Player player = (Player) sender;

			for (int i = 0; i < 200; i++) {
				Bukkit.broadcastMessage((String) "          ");
			}

			Bukkit.broadcastMessage(ChatColor
					.translateAlternateColorCodes('&',
							plugin.getConfig().getString("messages.clearchat.message",
									"&bWindCore&f: %arg0% cleared the chat!"))
					.replace("%arg0%", player.getDisplayName()));
		}

		return false;
	}

}
