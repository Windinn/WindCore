package com.windinn.windcore;

import org.bukkit.plugin.java.JavaPlugin;

import com.windinn.windcore.commands.ClearchatCommand;
import com.windinn.windcore.commands.DiscordCommand;
import com.windinn.windcore.commands.FeedCommand;
import com.windinn.windcore.commands.FlyCommand;
import com.windinn.windcore.commands.HealCommand;
import com.windinn.windcore.commands.InventorySeeCommand;
import com.windinn.windcore.commands.MsgCommand;
import com.windinn.windcore.commands.NicknameCommand;
import com.windinn.windcore.commands.ReplyCommand;
import com.windinn.windcore.commands.TwitterCommand;
import com.windinn.windcore.commands.WebsiteCommand;
import com.windinn.windcore.commands.YoutubeCommand;
import com.windinn.windcore.listeners.PlayerJoinListener;
import com.windinn.windcore.utils.VersionUpdater;

public class WindCore extends JavaPlugin {

	public void onEnable() {
		super.onEnable();

		VersionUpdater updater = new VersionUpdater();
		updater.checkUpdate("78973");

		saveDefaultConfig();

		getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

		getCommand("clearchat").setExecutor(new ClearchatCommand());
		getCommand("discord").setExecutor(new DiscordCommand());
		getCommand("feed").setExecutor(new FeedCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("inventorysee").setExecutor(new InventorySeeCommand());
		getCommand("msg").setExecutor(new MsgCommand());
		getCommand("nickname").setExecutor(new NicknameCommand());
		getCommand("reply").setExecutor(new ReplyCommand());
		getCommand("twitter").setExecutor(new TwitterCommand());
		getCommand("website").setExecutor(new WebsiteCommand());
		getCommand("youtube").setExecutor(new YoutubeCommand());
	}

	public void onDisable() {
		super.onDisable();
	}

}