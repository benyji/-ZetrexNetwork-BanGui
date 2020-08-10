package com.benyji.core.gui.builds;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.benyji.core.Main;
import com.benyji.core.gui.ItemStackBuilder;
import com.benyji.core.utils.TranslateColorCodes;

//(Material m, String n)
public class UI_Ver_1_14_4 {
	ItemStackBuilder e = new ItemStackBuilder();

	TranslateColorCodes c = new TranslateColorCodes();

	Plugin plugin = Bukkit.getPluginManager().getPlugin("ZetrexNetwork-BanGUI");

	Main main = Main.getPlugin(Main.class);

	public void applyUI(Player player, OfflinePlayer target) {

		Main.punish.setID(target.getUniqueId());

		Inventory gui = Bukkit.createInventory(null, 45, c.translate(plugin.getConfig().getString("guiTitle")));

		ItemStack xray = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("xray_icon")),
				plugin.getConfig().getString("xray_display_name"), "XRAY");
		gui.setItem(0, xray);

		ItemStack movement = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("movement_icon")),
				plugin.getConfig().getString("movement_display_name"), "MOVEMENT");
		gui.setItem(1, movement);

		ItemStack combat = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("combat_icon")),
				plugin.getConfig().getString("combat_display_name"), "COMBAT");
		gui.setItem(2, combat);

		ItemStack exploit = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("exploit_icon")),
				plugin.getConfig().getString("exploit_display_name"), "EXPLOIT");
		gui.setItem(3, exploit);

		ItemStack griefing = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("griefing_icon")),
				plugin.getConfig().getString("griefing_display_name"), "GRIEFING");
		gui.setItem(4, griefing);

		ItemStack discrimination = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("discrimination_icon")),
				plugin.getConfig().getString("discrimination_display_name"), "DISCRIMINATION");
		gui.setItem(5, discrimination);

		ItemStack impersonation = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("impersonation_icon")),
				plugin.getConfig().getString("impersonation_display_name"), "IMPERSONATION");
		gui.setItem(6, impersonation);

		ItemStack advertising = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("advertising_icon")),
				plugin.getConfig().getString("advertising_display_name"), "ADVERTISING");
		gui.setItem(7, advertising);

		ItemStack afk = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("afk_icon")),
				plugin.getConfig().getString("afk_display_name"), "AFK");
		gui.setItem(8, afk);

		ItemStack inappropriate = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("inappropriate_icon")),
				plugin.getConfig().getString("inappropriate_display_name"), "INAPPROPRIATE");
		gui.setItem(9, inappropriate);

		ItemStack harassment = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("harassment_icon")),
				plugin.getConfig().getString("harassment_display_name"), "HARASSMENT");
		gui.setItem(10, harassment);

		ItemStack sexual_harrasment = e.getLocalItem(
				Material.valueOf(plugin.getConfig().getString("sexual_harassment_icon")),
				plugin.getConfig().getString("sexual_harassment_display_name"), "S_HARASSMENT");
		gui.setItem(11, sexual_harrasment);

		ItemStack mining = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("mining_icon")),
				plugin.getConfig().getString("mining_display_name"), "MINING");
		gui.setItem(12, mining);

		ItemStack scaffold = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("scaffold_icon")),
				plugin.getConfig().getString("scaffold_display_name"), "SCAFFOLD");
		gui.setItem(13, scaffold);

		ItemStack derp = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("derp_icon")),
				plugin.getConfig().getString("derp_display_name"), "DERP");
		gui.setItem(14, derp);

		ItemStack crits = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("criticals_icon")),
				plugin.getConfig().getString("criticals_display_name"), "CRITICALS");
		gui.setItem(15, crits);

		ItemStack anti_kb = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("anti_kb_icon")),
				plugin.getConfig().getString("anti_kb_display_name"), "ANTI_KB");
		gui.setItem(16, anti_kb);

		ItemStack phase = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("phase_icon")),
				plugin.getConfig().getString("phase_display_name"), "PHASE");
		gui.setItem(17, phase);

		ItemStack lag_machine = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("lag_machine_icon")),
				plugin.getConfig().getString("lag_machine_display_name"), "LAG_MACHINE");
		gui.setItem(18, lag_machine);

		ItemStack ddos = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("ddos_icon")),
				plugin.getConfig().getString("ddos_display_name"), "DDOS");
		gui.setItem(19, ddos);

		ItemStack creative = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("creative_icon")),
				plugin.getConfig().getString("creative_display_name"), "CREATIVE");
		gui.setItem(20, creative);

		ItemStack minor = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("minor_icon")),
				plugin.getConfig().getString("minor_display_name"), "MINOR");
		gui.setItem(21, minor);

		ItemStack extreme_harassment = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("extreme_icon")),
				plugin.getConfig().getString("extreme_display_name"), "EXTREME");
		gui.setItem(22, extreme_harassment);

		ItemStack repeat_discrimination = e.getLocalItem(
				Material.valueOf(plugin.getConfig().getString("repeat_discrimination_icon")),
				plugin.getConfig().getString("repeat_discrimination_display_name"), "R_DISCRIMINATION");
		gui.setItem(23, repeat_discrimination);

		ItemStack manual_60 = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("manual_60_icon")),
				plugin.getConfig().getString("manual_60_display_name"), "MANUAL_60");
		gui.setItem(24, manual_60);

		ItemStack manual_raid = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("manual_raid_icon")),
				plugin.getConfig().getString("manual_raid_display_name"), "MANUAL_RAID");
		gui.setItem(25, manual_raid);

		ItemStack excessive_advertising = e.getLocalItem(
				Material.valueOf(plugin.getConfig().getString("excessive_advertising_icon")),
				plugin.getConfig().getString("excessive_advertising_display_name"), "E_ADVERTISING");
		gui.setItem(26, excessive_advertising);

		ItemStack alts_10 = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("alts_10_icon")),
				plugin.getConfig().getString("alts_10_display_name"), "ALTS_10");
		gui.setItem(27, alts_10);

		ItemStack manual_perm = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("manual_perm_icon")),
				plugin.getConfig().getString("manual_perm_display_name"), "MANUAL_PERM");
		gui.setItem(28, manual_perm);

		ItemStack ban_evasion = e.getLocalItem(Material.valueOf(plugin.getConfig().getString("ban_evasion_icon")),
				plugin.getConfig().getString("ban_evasion_display_name"), "BAN_EVASION");
		gui.setItem(29, ban_evasion);

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

		ItemStack kickButton;
		ItemMeta kickButtonMeta;

		kickButton = new ItemStack(Material.valueOf(plugin.getConfig().getString("kick_icon")));
		kickButtonMeta = kickButton.getItemMeta();
		kickButtonMeta.setDisplayName(c.translate(plugin.getConfig().getString("kick_display_name")));
		kickButtonMeta.setLocalizedName("KICK_BUTTON");
		kickButtonMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		kickButtonMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		kickButtonMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		kickButtonMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		kickButton.setItemMeta(kickButtonMeta);
		gui.setItem(33, kickButton);

		ItemStack muteButton;
		ItemMeta muteButtonMeta;
		ArrayList<String> Lore = new ArrayList<String>();

		muteButton = new ItemStack(Material.valueOf(plugin.getConfig().getString("mute_icon")));
		muteButtonMeta = muteButton.getItemMeta();
		muteButtonMeta.setDisplayName(c.translate(plugin.getConfig().getString("mute_display_name")));
		muteButtonMeta.setLocalizedName("MUTE_BUTTON");

		Lore.add(c.translate("Mute Duration: " + ChatColor.RED + e.removeTime(plugin.getConfig().getString("mute_time"))
				+ " " + e.time(plugin.getConfig().getString("mute_time"))));
		muteButtonMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		muteButtonMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		muteButtonMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		muteButtonMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		muteButtonMeta.setLore(Lore);

		muteButton.setItemMeta(muteButtonMeta);
		gui.setItem(34, muteButton);

		ItemStack unbanButton;
		ItemMeta unbanButtonMeta;

		unbanButton = new ItemStack(Material.valueOf(plugin.getConfig().getString("unban_icon")));
		unbanButtonMeta = unbanButton.getItemMeta();
		unbanButtonMeta.setDisplayName(c.translate(plugin.getConfig().getString("unban_display_name")));
		unbanButtonMeta.setLocalizedName("UNBAN_BUTTON");
		unbanButtonMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		unbanButtonMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		unbanButtonMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		unbanButtonMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		unbanButton.setItemMeta(unbanButtonMeta);
		gui.setItem(35, unbanButton);

		if (plugin.getConfig().getBoolean("showCredits") == true) {
			ItemStack credits;
			ItemMeta creditsMeta;
			ArrayList<String> creditsLore = new ArrayList<String>();

			credits = new ItemStack(Material.POPPY);
			creditsMeta = credits.getItemMeta();
			creditsMeta.setDisplayName(
					ChatColor.GRAY + "Developed by " + ChatColor.YELLOW + "Benyji" + ChatColor.GRAY + ".");
			creditsLore.add(ChatColor.GRAY + "View more plugins on:");
			creditsLore.add(ChatColor.GOLD + "Spigot - Benyji");
			creditsLore.add(ChatColor.GRAY + "Contact:");
			creditsLore.add(ChatColor.BLUE + "Disc - benyji#4392");
			creditsLore.add(ChatColor.GRAY + "Made with love <3");
			creditsMeta.setLocalizedName("CREDITS_ICON");
			creditsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			creditsMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
			creditsMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
			creditsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
			creditsMeta.setLore(creditsLore);
			credits.setItemMeta(creditsMeta);
			gui.setItem(32, credits);
		}
		ItemStack backButton;
		ItemMeta backButtonMeta;

		backButton = new ItemStack(Material.BARRIER, 1);
		backButtonMeta = backButton.getItemMeta();
		backButtonMeta.setDisplayName(ChatColor.RED + "Close Menu");
		backButtonMeta.setLocalizedName("MENU_CLOSE_BUTTON");
		backButton.setItemMeta(backButtonMeta);
		gui.setItem(44, backButton);

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

		player.openInventory(gui);

	}

}
