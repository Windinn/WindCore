package com.windinn.windcore.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.windinn.windcore.WindCore;

public class VersionUpdater {

	public void checkUpdate(String resourceID) {
		try {
			HttpsURLConnection connection = (HttpsURLConnection) new URL(
					"https://api.spigotmc.org/legacy/update.php?resource=" + resourceID).openConnection();
			int timed_out = 1250; // check if API is available, set your time as you want
			connection.setConnectTimeout(timed_out);
			connection.setReadTimeout(timed_out);
			String localPluginVersion = JavaPlugin.getPlugin(WindCore.class).getDescription().getVersion();
			String spigotPluginVersion = new BufferedReader(new InputStreamReader(connection.getInputStream()))
					.readLine();

			if (!spigotPluginVersion.equals(localPluginVersion)) {
				JavaPlugin.getPlugin(WindCore.class).getLogger().info("A new version is available for WindCore! "
						+ localPluginVersion + " --> " + spigotPluginVersion);
			} else {
				JavaPlugin.getPlugin(WindCore.class).getLogger().info("WindCore is up-to-date !");
			}

			connection.disconnect();
		} catch (Exception e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Failed to check for an update on SpigotMC.org!");
			e.printStackTrace();
		}

	}

}
