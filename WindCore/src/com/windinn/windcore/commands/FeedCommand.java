package com.windinn.windcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.windinn.windcore.WindCore;

public class FeedCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		JavaPlugin plugin = JavaPlugin.getPlugin(WindCore.class);

		if (sender instanceof Player) {
			Player player = (Player) sender;

			if (args.length == 0) {
				player.setFoodLevel(20);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
						.getString("messages.feed.feed-yourself", "&bWindCore&f: You have been feeded!")));
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
					player.setFoodLevel(20);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
							.getString("messages.feed.feed-yourself", "&bWindCore&f: You have been feeded!")));
					return false;
				}

				player2.setFoodLevel(20);
				player.sendMessage(
						ChatColor
								.translateAlternateColorCodes('&',
										plugin.getConfig().getString("messages.feed.feeded-player",
												"&bWindCore&f: You feeded %arg0%"))
								.replace("%arg0%", player2.getName()));
				player2.sendMessage(ChatColor
						.translateAlternateColorCodes('&',
								plugin.getConfig().getString("messages.feed.feeded-by-player",
										"&bWindCore&f: You have been feeded by %arg0%"))
						.replace("%arg0%", player.getName()));
			}

		}

		return false;
	}

}
