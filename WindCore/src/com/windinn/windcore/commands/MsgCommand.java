package com.windinn.windcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.windinn.windcore.WindCore;
import com.windinn.windcore.utils.UserDataHandler;

public class MsgCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		JavaPlugin plugin = JavaPlugin.getPlugin(WindCore.class);

		if (sender instanceof Player) {
			Player player = (Player) sender;
			UserDataHandler userData = new UserDataHandler(player.getUniqueId());

			if (args.length <= 1) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(
						"messages.msg.invalid-usage", "&bWindCore&f: Correct usage is /msg <player> <message>")));
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
							plugin.getConfig().getString("messages.msg.cant-talk-to-yourself",
									"&bWindCore&f: You can't send a message to yourself!")));
					return false;
				}

				UserDataHandler userData2 = new UserDataHandler(player2.getUniqueId());
				String message = "";

				for (int i = 1; i < args.length; i++) {
					message += args[i] + " ";
				}

				message = message.substring(0, message.length() - 1);

				userData.getUserFile().set("temp.msg.reply1", player2.getName());
				userData.saveUserFile();

				userData2.getUserFile().set("temp.msg.reply2", player.getName());
				userData2.saveUserFile();

				player.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED + "Me " + ChatColor.GOLD + "-> " + ChatColor.RED
						+ player2.getDisplayName() + ChatColor.GOLD + "] " + ChatColor.RESET + message);
				player2.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED + player.getDisplayName() + ChatColor.GOLD
						+ " -> " + ChatColor.RED + "Me" + ChatColor.GOLD + "] " + ChatColor.RESET + message);
			}

		}

		return false;
	}

}
