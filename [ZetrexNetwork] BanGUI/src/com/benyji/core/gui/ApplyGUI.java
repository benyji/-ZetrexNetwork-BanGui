package com.benyji.core.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.benyji.core.Main;
import com.benyji.core.gui.builds.UI_Ver_1_14_4;

public class ApplyGUI {

	Main main = Main.getPlugin(Main.class);
	Plugin plugin = Bukkit.getPluginManager().getPlugin("ZetrexNetwork-BanGUI");

	UI_Ver_1_14_4 ver1_14_4 = new UI_Ver_1_14_4();

	public void applyUIVer(Player player) {
		ver1_14_4.applyUI(player);
	}
}
