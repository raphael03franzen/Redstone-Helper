package com.raphael03franzen.redstoneHelper;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class RedstoneHelper extends JavaPlugin {

	@Override
	public void onEnable() {
		System.out.println("Redstone Helper Loaded");
		Objects.requireNonNull(this.getCommand("barrel")).setExecutor(new BarrelCommand());
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
