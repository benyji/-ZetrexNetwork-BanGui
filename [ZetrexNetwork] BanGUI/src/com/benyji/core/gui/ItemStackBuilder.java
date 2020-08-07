package com.benyji.core.gui;

import org.bukkit.Material;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.benyji.core.utils.TranslateColorCodes;

public class ItemStackBuilder {

	TranslateColorCodes c = new TranslateColorCodes();

	
	public ItemStack getLocalItem(Material m, String n) {

		ItemStack item = new ItemStack(m);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(c.translate(n));
		// meta.setLore(Arrays.asList(ChatColor.RED.toString() + ChatColor.UNDERLINE +
		// "Click to remove"));
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

		item.setItemMeta(meta);
		return item;
	}

}
