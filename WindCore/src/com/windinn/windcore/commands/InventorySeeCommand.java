package com.windinn.windcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.windinn.windcore.WindCore;

public class InventorySeeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		JavaPlugin plugin = JavaPlugin.getPlugin(WindCore.class);

		if (sender instanceof Player) {
			Player player = (Player) sender;

			if (args.length == 0) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("messages.inventorysee.cant-see-own-inventory",
								"&bWindCore&f: You can't check your own inventory.")));
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
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',
							plugin.getConfig().getString("messages.inventorysee.cant-see-own-inventory",
									"&bWindCore&f: You can't check your own inventory.")));
					return false;
				}

				player.openInventory(player2.getInventory());
			}

		}

		return false;
	}

}
