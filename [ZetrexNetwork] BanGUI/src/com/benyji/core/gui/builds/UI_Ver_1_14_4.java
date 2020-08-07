package com.benyji.core.gui.builds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.benyji.core.gui.ItemStackBuilder;
import com.benyji.core.utils.TranslateColorCodes;

//(Material m, String n)
public class UI_Ver_1_14_4 {
	ItemStackBuilder e = new ItemStackBuilder();

	TranslateColorCodes c = new TranslateColorCodes();

	Plugin plugin = Bukkit.getPluginManager().getPlugin("ZetrexNetwork-BanGUI");

	public void applyUI(Player player) {

		Inventory gui = Bukkit.createInventory(null, 45, c.translate(plugin.getConfig().getString("guiTitle")));

		ItemStack xray = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("xray_icon")),
				plugin.getConfig().getString("xray_display_name"));
		gui.setItem(0, xray);

		ItemStack movement = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("movement_icon")),
				plugin.getConfig().getString("movement_display_name"));
		gui.setItem(1, movement);

		ItemStack combat = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("combat_icon")),
				plugin.getConfig().getString("combat_display_name"));
		gui.setItem(2, combat);

		ItemStack exploit = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("exploit_icon")),
				plugin.getConfig().getString("exploit_display_name"));
		gui.setItem(3, exploit);

		ItemStack griefing = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("griefing_icon")),
				plugin.getConfig().getString("griefing_display_name"));
		gui.setItem(4, griefing);

		ItemStack discrimination = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("discrimination_icon")),
				plugin.getConfig().getString("discrimination_display_name"));
		gui.setItem(5, discrimination);
		
		ItemStack impersonation = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("impersonation_icon")),
				plugin.getConfig().getString("impersonation_display_name"));
		gui.setItem(6, impersonation);
		
		ItemStack advertising = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("advertising_icon")),
				plugin.getConfig().getString("advertising_display_name"));
		gui.setItem(7, advertising);
		
		ItemStack afk = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("afk_icon")),
				plugin.getConfig().getString("afk_display_name"));
		gui.setItem(8, afk);
		
		ItemStack inappropriate = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("inappropriate_icon")),
				plugin.getConfig().getString("inappropriate_display_name"));
		gui.setItem(9, inappropriate);
		
		ItemStack harassment = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("harassment_icon")),
				plugin.getConfig().getString("harassment_display_name"));
		gui.setItem(10, harassment);
		
		ItemStack sexual_harrasment = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("sexual_harrasment_icon")),
				plugin.getConfig().getString("sexual_harrasment_display_name"));
		gui.setItem(11, sexual_harrasment);
		
		ItemStack mining = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("mining_icon")),
				plugin.getConfig().getString("mining_display_name"));
		gui.setItem(12, mining);
		
		ItemStack scaffold = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("scaffold_icon")),
				plugin.getConfig().getString("scaffold_display_name"));
		gui.setItem(13, scaffold);
		
		ItemStack derp = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("derp_icon")),
				plugin.getConfig().getString("derp_display_name"));
		gui.setItem(14, derp);
		
		ItemStack crits = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("criticals_icon")),
				plugin.getConfig().getString("criticals_display_name"));
		gui.setItem(15, crits);
		
		ItemStack anti_kb = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("anti_kb_icon")),
				plugin.getConfig().getString("anti_kb_display_name"));
		gui.setItem(16, anti_kb);
		
		ItemStack phase = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("phase_icon")),
				plugin.getConfig().getString("phase_display_name"));
		gui.setItem(17, phase);
		
		ItemStack lag_machine = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("lag_machine_icon")),
				plugin.getConfig().getString("lag_machine_display_name"));
		gui.setItem(18, lag_machine);
		
		ItemStack ddos = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("ddos_icon")),
				plugin.getConfig().getString("ddos_display_name"));
		gui.setItem(19, ddos);
		
		ItemStack creative = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("creative_icon")),
				plugin.getConfig().getString("creative_display_name"));
		gui.setItem(20, creative);
		
		ItemStack minor = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("minor_icon")),
				plugin.getConfig().getString("minor_display_name"));
		gui.setItem(21, minor);
		
		ItemStack extreme_harassment = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("extreme_icon")),
				plugin.getConfig().getString("extreme_display_name"));
		gui.setItem(22, extreme_harassment);
		
		ItemStack backButton;
		ItemMeta backButtonMeta;

		backButton = new ItemStack(Material.BARRIER, 1);
		backButtonMeta = backButton.getItemMeta();
		backButtonMeta.setDisplayName(ChatColor.RED + "Close Menu");
		backButtonMeta.setLocalizedName("MENU_CLOSE_BUTTON");
		backButton.setItemMeta(backButtonMeta);
		gui.setItem(44, backButton);

		player.openInventory(gui);
	}

}