package com.windinn.windcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.windinn.windcore.WindCore;

public class HealCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		JavaPlugin plugin = JavaPlugin.getPlugin(WindCore.class);

		if (sender instanceof Player) {
			Player player = (Player) sender;

			if (args.length == 0) {
				player.setHealth(20d);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
						.getString("messages.heal.heal-yourself", "&bWindCore&f: You have been healed!")));
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
					player.setHealth(20d);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
							.getString("messages.heal.heal-yourself", "&bWindCore&f: You have been healed!")));
					return false;
				}

				player2.setHealth(20d);
				player.sendMessage(
						ChatColor
								.translateAlternateColorCodes('&',
										plugin.getConfig().getString("messages.heal.healed-player",
												"&bWindCore&f: You healed %arg0%"))
								.replace("%arg0%", player2.getName()));
				player2.sendMessage(ChatColor
						.translateAlternateColorCodes('&',
								plugin.getConfig().getString("messages.heal.healed-by-player",
										"&bWindCore&f: You have been healed by %arg0%"))
						.replace("%arg0%", player.getName()));
			}

		}

		return false;
	}

}
