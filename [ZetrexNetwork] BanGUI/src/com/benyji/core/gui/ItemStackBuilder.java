package com.benyji.core.gui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.benyji.core.utils.TranslateColorCodes;

import net.md_5.bungee.api.ChatColor;

public class ItemStackBuilder {

	TranslateColorCodes c = new TranslateColorCodes();
	Plugin plugin = Bukkit.getPluginManager().getPlugin("ZetrexNetwork-BanGUI");

	ArrayList<String> Lore = new ArrayList<String>();

	public ItemStack getLocalItem(Material m, String n, String type) {

		ItemStack item = new ItemStack(m);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(c.translate(n));

		switch (type) {
		case "XRAY":
			Lore.add(c.translate("Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("xray_time")) + " "
					+ time(plugin.getConfig().getString("xray_time"))));
			System.out.println(removeTime(plugin.getConfig().getString("xray_time")));
			break;

		default:

		}

		// Set user history grey and yellow

		meta.setLore(Lore);
		Lore.clear();

		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

		item.setItemMeta(meta);
		return item;
	}

	public String removeTime(String str) {
		str.toLowerCase();
		str.replace("d", "");
		str.replace("m", "");
		str.replace("w", "");
		str.replace("s", "");
		return str;
	}

	public String time(String str) {
		if (str.contains("M")) {
			return "Month(s)";
		} else if (str.contains("m")) {
			return "Minute(s)";
		} else if (str.toLowerCase().contains("d")){
			return "Day(s)";
		} else if (str.toLowerCase().contains("w")) {
			return "Week(s)";
		} else if (str.toLowerCase().contains("s")) {
			return "Second(s)";
		} else {
			return "INVALID; USE (d, w, m, s)";
		}
	}
}
