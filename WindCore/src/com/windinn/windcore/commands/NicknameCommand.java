package com.windinn.windcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.windinn.windcore.WindCore;

public class NicknameCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		JavaPlugin plugin = JavaPlugin.getPlugin(WindCore.class);

		if (sender instanceof Player) {

			Player player = (Player) sender;

			if (args.length == 0) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(
						"messages.nickname.invalid-usage", "&bWindCore&f: Correct usage is /nickname <display name>")));
			} else {
				String nickname = args[0];

				if (nickname.equals("reset") || nickname.equalsIgnoreCase(player.getName())) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(
							"messages.nickname.nickame-resetted", "&bWindCore&f: Your nickname has been resetted.")));
					player.setDisplayName(player.getName());
					return false;
				}

				if ((nickname = ChatColor.translateAlternateColorCodes('&', (String) nickname)).length() > 16) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&',
							plugin.getConfig().getString("messages.nickname.nickame-too-long",
									"&bWindCore&f: Your nickname can not exceed 16 characters!")));
					return false;
				}

				nickname = "~" + nickname;
				nickname = String.valueOf(nickname) + ChatColor.RESET;
				player.setDisplayName(nickname);
				player.sendMessage(ChatColor
						.translateAlternateColorCodes('&',
								plugin.getConfig().getString("messages.nickname.nickame-set-to",
										"&bWindCore&f: Your nickname has been set to %arg0%"))
						.replace("%arg0%", nickname));
			}

		}

		return false;
	}

}
