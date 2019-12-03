package work.mgnet.customstructuresapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import work.mgnet.customstructuresapi.listener.ChunkListener;
import work.mgnet.customstructuresapi.listener.CommandListener;
import work.mgnet.customstructuresapi.manager.StructureManager;
import work.mgnet.customstructuresapi.todo.StructureSpawner;

public class CustomStructuresAPI extends JavaPlugin {
	
	/**
	 * @author MCPfannkuchenYT
	 * @version 1.0
	 */
	
	public static StructureManager structureManager = new StructureManager(); // Structure Instance
	
	@Override
	public void onEnable() {
		this.getLogger().info("CustomStructuresAPI is now going to enable.");
		this.getLogger().info("There are " + structureManager.getStructures().size() + " loaded structures.");
		Bukkit.getPluginManager().registerEvents(new ChunkListener(), this); // Registering Chunk Listener
		Bukkit.getPluginManager().registerEvents(new CommandListener(), this); // Registering Locate Listener
		this.getLogger().info("CustomStructuresAPI was enabled. OK");
		loadConfiguration(); // Load Configuration
	}
	
	// Method is used to Save the File
	public void saveConfiguration() {
		try {
			if (!getDataFolder().exists()) getDataFolder().mkdir(); // Create Data Folder if it doesn't exist
			if (!new File(getDataFolder(), "spawned.yml").exists()) new File(getDataFolder(), "spawned.yml").createNewFile(); // Create File if it doesn't exist
			PrintWriter pw = new PrintWriter(new File(getDataFolder(), "spawned.yml")); // Clear File 
			pw.write(""); // by writing an empty string
			pw.close(); // Closing File
			ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream(new File(getDataFolder(), "spawned.yml"))); // Open Object Writer
			objectWriter.writeObject(StructureSpawner.placedStructures); // Write Objects
			objectWriter.close(); // Close File
		} catch (Exception e) {
			this.getLogger().info("Could not save the File."); // Error
		}
	}
	
	@SuppressWarnings("unchecked") // Ignore please
	public void loadConfiguration() {
		try {
			if (!getDataFolder().exists()) getDataFolder().mkdir(); // Create Data Folder if it doesn't exist
			if (!new File(getDataFolder(), "spawned.yml").exists()) new File(getDataFolder(), "spawned.yml").createNewFile(); // Create File if it doesn't exist
			ObjectInputStream objectLoader = new ObjectInputStream(new FileInputStream(new File(getDataFolder(), "spawned.yml"))); // Open Reader
			StructureSpawner.placedStructures = (HashMap<String, Map<String, Object>>) objectLoader.readObject(); // Read
			objectLoader.close(); // Close
		} catch (Exception e) {
			this.getLogger().info("Could not load the File. Maybe it is empty? If yes that is Okay."); // Error
		}
	}
	
}
