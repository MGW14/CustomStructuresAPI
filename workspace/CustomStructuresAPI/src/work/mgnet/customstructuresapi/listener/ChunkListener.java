package work.mgnet.customstructuresapi.listener;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import work.mgnet.customstructuresapi.CustomStructuresAPI;
import work.mgnet.customstructuresapi.todo.StructureSpawner;

public class ChunkListener implements Listener {
	/**
	 * @author MCPfannkuchenYT
	 * @version 1.0
	 */
	
	@EventHandler
	public void onChunkGeneration(ChunkLoadEvent e) {
		
		if (e.isNewChunk()) { // If Chunk will be generated right now
			if (new Random().nextInt(1000) == 1) { // If Random equals 1 a Structure will be generated
				World w = e.getChunk().getWorld(); // Get World
				Block b = e.getChunk().getBlock(0, 5, 0); // Get Main Block of Chunk
				boolean foundLand = false;
				Block bb = e.getChunk().getBlock(0, w.getHighestBlockYAt(b.getX(), b.getZ()), 0); // Get Block for Structure to spawn
				int trys = 0; // Anti-crash
				while (!foundLand){
					if(trys >= 20) return; // Anti-crash
					if(bb.getType() != Material.AIR){ // Check if Block is able to hold a Structure
						foundLand = true;
					}
					else{
						bb = bb.getLocation().subtract(0, 1, 0).getBlock(); // Get Block under Air
					}
					trys++; // Anti-crash
				}
				
				StructureSpawner.spawn(CustomStructuresAPI.structureManager.random(), bb, e.getChunk()); // Spawn the structure
				
			}
		}
	}
	
}