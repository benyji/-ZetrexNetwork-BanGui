package com.benyji.core.gui;

import litebans.api.Database;
import static com.benyji.core.Main.punish;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

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
	UUID identifier;

	public void setID(UUID uuid) {
		identifier = uuid;
	}

	public ItemStack getLocalItem(Material m, String n, String type) {
		
		Lore.clear();
		
		ItemStack item = new ItemStack(m);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(c.translate(n));

		setTime(type);

		// Set user history grey and yellow
		// boolean: punish.preferences.get(identifier)
		CompletableFuture.runAsync(() -> {
		    String uuid = identifier.toString();
		    String query = "SELECT * FROM {bans} WHERE uuid=?";
		 
		    try (PreparedStatement st = Database.get().prepareStatement(query)) {
		        st.setString(1, uuid);
		     
		        try (ResultSet rs = st.executeQuery()) {
		            while (rs.next()) {
		                String reason = rs.getString("reason");
		                setHistory(reason, m);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}).thenRun(() -> {
			meta.setLore(Lore);

			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
			meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
			meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

			item.setItemMeta(meta);

		});
		return item;

	}
	

	public void setHistory(String reason, Material m) {
		System.out.println("1");
		if (reason == plugin.getConfig().getString("advertising_reason")) {
			System.out.println("2");

			if (Material.valueOf(plugin.getConfig().getString("advertising_icon")) != null) {
				System.out.println("3");

				Lore.add(ChatColor.GRAY + "Previously banned: " + ChatColor.RED + "YES");
			}

		} else {
			System.out.println("4");

			Lore.add(ChatColor.GRAY + "Previously banned: " + ChatColor.YELLOW + "NO");
		}
	}

	public void setTime(String type) {
		switch (type) {
		case "XRAY":
			Lore.add(
					c.translate("Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("xray_time"))
							+ " " + time(plugin.getConfig().getString("xray_time"))));
			break;

		case "MOVEMENT":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("movement_time")) + " "
							+ time(plugin.getConfig().getString("movement_time"))));
			break;

		case "COMBAT":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("combat_time")) + " "
							+ time(plugin.getConfig().getString("combat_time"))));
			break;

		case "EXPLOIT":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("exploit_time")) + " "
							+ time(plugin.getConfig().getString("exploit_time"))));
			break;

		case "GRIEFING":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("griefing_time")) + " "
							+ time(plugin.getConfig().getString("griefing_time"))));
			break;

		case "DISCRIMINATION":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("discrimination_time"))
							+ " " + time(plugin.getConfig().getString("discrimination_time"))));
			break;

		case "IMPERSONATION":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("impersonation_time"))
							+ " " + time(plugin.getConfig().getString("impersonation_time"))));
			break;

		case "ADVERTISING":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("advertising_time"))
							+ " " + time(plugin.getConfig().getString("advertising_time"))));
			break;

		case "AFK":
			Lore.add(c.translate("Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("afk_time"))
					+ " " + time(plugin.getConfig().getString("afk_time"))));
			break;

		case "INAPPROPRIATE":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("inappropriate_time"))
							+ " " + time(plugin.getConfig().getString("inappropriate_time"))));
			break;

		case "HARASSMENT":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("harassment_time")) + " "
							+ time(plugin.getConfig().getString("harassment_time"))));
			break;

		case "S_HARASSMENT":
			Lore.add(c.translate("Ban Duration: " + ChatColor.RED
					+ removeTime(plugin.getConfig().getString("sexual_harassment_time")) + " "
					+ time(plugin.getConfig().getString("sexual_harassment_time"))));
			break;

		case "MINING":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("mining_time")) + " "
							+ time(plugin.getConfig().getString("mining_time"))));
			break;

		case "SCAFFOLD":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("scaffold_time")) + " "
							+ time(plugin.getConfig().getString("scaffold_time"))));
			break;

		case "DERP":
			Lore.add(
					c.translate("Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("derp_time"))
							+ " " + time(plugin.getConfig().getString("derp_time"))));
			break;

		case "CRITICALS":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("criticals_time")) + " "
							+ time(plugin.getConfig().getString("criticals_time"))));
			break;

		case "ANTI_KB":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("anti_kb_time")) + " "
							+ time(plugin.getConfig().getString("anti_kb_time"))));
			break;

		case "PHASE":
			Lore.add(c
					.translate("Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("phase_time"))
							+ " " + time(plugin.getConfig().getString("phase_time"))));
			break;

		case "LAG_MACHINE":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("lag_machine_time"))
							+ " " + time(plugin.getConfig().getString("lag_machine_time"))));
			break;

		case "DDOS":
			Lore.add(
					c.translate("Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("ddos_time"))
							+ " " + time(plugin.getConfig().getString("ddos_time"))));
			break;

		case "CREATIVE":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("creative_time")) + " "
							+ time(plugin.getConfig().getString("creative_time"))));
			break;

		case "MINOR":
			Lore.add(c
					.translate("Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("minor_time"))
							+ " " + time(plugin.getConfig().getString("minor_time"))));
			break;

		case "EXTREME":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("extreme_time")) + " "
							+ time(plugin.getConfig().getString("extreme_time"))));
			break;

		case "R_DISCRIMINATION":
			Lore.add(c.translate("Ban Duration: " + ChatColor.RED
					+ removeTime(plugin.getConfig().getString("repeat_discrimination_time")) + " "
					+ time(plugin.getConfig().getString("repeat_discrimination_time"))));
			break;

		case "MANUAL_60":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("manual_60_time")) + " "
							+ time(plugin.getConfig().getString("manual_60_time"))));
			break;

		case "MANUAL_RAID":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("manual_raid_time"))
							+ " " + time(plugin.getConfig().getString("manual_raid_time"))));
			break;

		case "E_ADVERTISING":
			Lore.add(c.translate("Ban Duration: " + ChatColor.RED
					+ removeTime(plugin.getConfig().getString("excessive_advertising_time")) + " "
					+ time(plugin.getConfig().getString("excessive_advertising_time"))));
			break;

		case "ALTS_10":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("alts_10_time")) + " "
							+ time(plugin.getConfig().getString("alts_10_time"))));
			break;

		case "MANUAL_PERM":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("manual_perm_time"))
							+ " " + time(plugin.getConfig().getString("manual_perm_time"))));
			break;

		case "BAN_EVASION":
			Lore.add(c.translate(
					"Ban Duration: " + ChatColor.RED + removeTime(plugin.getConfig().getString("ban_evasion_time"))
							+ " " + time(plugin.getConfig().getString("ban_evasion_time"))));
			break;

		default:

		}
	}

	public String removeTime(String str) {
		str.toLowerCase();
		str = str.substring(0, str.length() - 1);
		return str;
	}

	public String time(String str) {
		if (str.contains("M")) {
			return "Month(s)";
		} else if (str.contains("m")) {
			return "Minute(s)";
		} else if (str.toLowerCase().contains("d")) {
			return "Day(s)";
		} else if (str.toLowerCase().contains("w")) {
			return "Week(s)";
		} else if (str.toLowerCase().contains("s")) {
			return "Second(s)";
		} else if (str.toLowerCase().contains("y")) {
			return "Year(s)";
		} else {
			return "INVALID; CONTACT 'benyji'";
		}
	}
}
