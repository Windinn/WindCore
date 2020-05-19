package com.windinn.windcore;

import org.bukkit.plugin.java.JavaPlugin;

import com.windinn.windcore.commands.ClearchatCommand;
import com.windinn.windcore.commands.FeedCommand;
import com.windinn.windcore.commands.FlyCommand;
import com.windinn.windcore.commands.HealCommand;
import com.windinn.windcore.commands.InventorySeeCommand;
import com.windinn.windcore.commands.NicknameCommand;
import com.windinn.windcore.utils.VersionUpdater;

public class WindCore extends JavaPlugin {

	public void onEnable() {
		super.onEnable();

		VersionUpdater updater = new VersionUpdater();
		updater.checkUpdate("78973");

		this.saveDefaultConfig();

		this.getCommand("clearchat").setExecutor(new ClearchatCommand());
		this.getCommand("feed").setExecutor(new FeedCommand());
		this.getCommand("fly").setExecutor(new FlyCommand());
		this.getCommand("heal").setExecutor(new HealCommand());
		this.getCommand("inventorysee").setExecutor(new InventorySeeCommand());
		this.getCommand("nickname").setExecutor(new NicknameCommand());
	}

	public void onDisable() {
		super.onDisable();
	}

}