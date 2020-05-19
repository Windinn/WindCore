package com.windinn.windcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.windinn.windcore.WindCore;

public class FlyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		JavaPlugin plugin = JavaPlugin.getPlugin(WindCore.class);

		if (sender instanceof Player) {
			Player player = (Player) sender;

			if (args.length == 0) {

				if (player.getAllowFlight()) {
					player.setAllowFlight(false);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
							.getString("messages.fly.can-not-longer-fly", "&bWindCore&f: You can not longer fly.")));
				} else {
					player.setAllowFlight(true);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
							.getString("messages.fly.can-now-fly", "&bWindCore&f: You can now fly.")));
				}

			} else {
				Player player2 = Bukkit.getPlayer(args[0]);

				if (player2 == null) {
					player.sendMessage(ChatColor
							.translateAlternateColorCodes('&', plugin.getConfig()
									.getString("messages.general.player-offline", "&bWindCore&f: %arg0% is offline!"))
							.replace("%arg0%", args[0]));
					return false;
				}

				if (player.getName().equals(player2.getName())) {

					if (player.getAllowFlight()) {
						player.setAllowFlight(false);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(
								"messages.fly.can-not-longer-fly", "&bWindCore&f: You can not longer fly.")));
					} else {
						player.setAllowFlight(true);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
								.getString("messages.fly.can-now-fly", "&bWindCore&f: You can now fly.")));
					}

					return false;
				}

				if (player2.getAllowFlight()) {
					player.sendMessage(ChatColor
							.translateAlternateColorCodes('&',
									plugin.getConfig().getString("messages.fly.player-can-not-longer-fly",
											"&bWindCore&f: %arg0% can not longer fly."))
							.replace("%arg0%", player2.getDisplayName()));
					player2.setAllowFlight(false);
					player2.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
							.getString("messages.fly.can-not-longer-fly", "&bWindCore&f: You can not longer fly.")));
				} else {
					player.sendMessage(ChatColor
							.translateAlternateColorCodes('&',
									plugin.getConfig().getString("messages.fly.player-can-now-fly",
											"&bWindCore&f: %arg0% can now fly."))
							.replace("%arg0%", player2.getDisplayName()));
					player2.setAllowFlight(true);
					player2.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
							.getString("messages.fly.can-now-fly", "&bWindCore&f: You can now fly.")));
				}

			}
		}

		return false;
	}

}
