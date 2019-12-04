package work.mgnet.customstructuresapi.todo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

import work.mgnet.customstructuresapi.CustomStructuresAPI;
import work.mgnet.customstructuresapi.manager.BlockLocation;
import work.mgnet.customstructuresapi.manager.Structure;

public class StructureSpawner {
	
	/**
	 * @author MCPfannkuchenYT
	 * @version 1.0
	 */
	
	public static HashMap<String, Map<String, Object>> placedStructures = new HashMap<String, Map<String, Object>>(); // List with Placed Structures
	
	// Spawn a Structure
	public static void spawn(Structure structure, Block bb, Chunk chunk) {
		if (bb.getType() == Material.WATER || bb.getType() == Material.LAVA) // Cannot spawn on WATER / LAVA
			return;
		Bukkit.getLogger().info("A new Structure was generated: " + structure.getName() + " at " + bb.getX() + " " + bb.getZ());
		placedStructures.put(structure.getName().toLowerCase(), bb.getLocation().serialize()); // Add Structure to List
		((CustomStructuresAPI) Bukkit.getPluginManager().getPlugin("CustomStructuresAPI")).saveConfiguration(); // Save the Configuration
		
		for (BlockLocation bl : structure.getBlocks()) { // Get Every Single Block
			bl.getLoc(bb.getLocation()).getBlock().setType(bl.getMat()); // Get Block from Offset and Change Material of it
			if (bl.getMat() == Material.CHEST) { // If Item is Chest
				int loot = 0; // Slots filled in Chest
				while (loot < 10) { // If less than 5 Items are in the Chest rerun the code
					for (ItemStack commonLoot : structure.getCommonLoot()) { // Get Loot
						if (true) { // Get Random Number
							((Chest) bl.getLoc(bb.getLocation()).getBlock().getState()).getInventory().setItem(new Random().nextInt(27), commonLoot); // Place item in Chest
							loot++; // Raise Number
						}
					}
					for (ItemStack uncommonLoot : structure.getUncommonLoot()) { // Same
						if (LootRandomizer.spawnLoot(4)) {
							((Chest) bl.getLoc(bb.getLocation()).getBlock().getState()).getInventory().setItem(new Random().nextInt(27), uncommonLoot);
							loot++;
						}
					}
					for (ItemStack rareLoot : structure.getRareLoot()) { // Same
						if (LootRandomizer.spawnLoot(6)) {
							((Chest) bl.getLoc(bb.getLocation()).getBlock().getState()).getInventory().setItem(new Random().nextInt(27), rareLoot);
							loot++;
						}
					}
					for (ItemStack epicLoot : structure.getEpicLoot()) { // Same
						if (LootRandomizer.spawnLoot(14)) {
							((Chest) bl.getLoc(bb.getLocation()).getBlock().getState()).getInventory().setItem(new Random().nextInt(27), epicLoot);
							loot++;
						}
					}
					for (ItemStack legendaryLoot : structure.getLegendaryLoot()) { // Same
						if (LootRandomizer.spawnLoot(50)) {
							((Chest) bl.getLoc(bb.getLocation()).getBlock().getState()).getInventory().setItem(new Random().nextInt(27), legendaryLoot);
							loot++;
						}
					}
				}
			}
		}
	}
	
}
