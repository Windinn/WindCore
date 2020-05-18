package com.windinn.windcore;

import org.bukkit.plugin.java.JavaPlugin;

import com.windinn.windcore.commands.ClearchatCommand;
import com.windinn.windcore.commands.NicknameCommand;

public class WindCore extends JavaPlugin {

	public void onEnable() {
		super.onEnable();

		this.saveDefaultConfig();

		this.getCommand("clearchat").setExecutor(new ClearchatCommand());
		this.getCommand("nickname").setExecutor(new NicknameCommand());
	}

	public void onDisable() {
		super.onDisable();
	}

}