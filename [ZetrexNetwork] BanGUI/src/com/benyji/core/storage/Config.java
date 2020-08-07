package com.benyji.core.storage;

import java.io.File;
import java.io.IOException;

import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils;

import com.benyji.core.Main;


public class Config {
	private Main plugin;

	public Config(Main plugin) {
        this.plugin = plugin;

	}
	public void Setup() {
		File file = new File(plugin.getDataFolder(), "config.yml");
		try {
			if (!(file.exists())) {
				file.createNewFile();
				FileUtils.copyToFile(plugin.getResource("config.yml"), file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}