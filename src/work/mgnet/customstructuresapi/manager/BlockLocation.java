package work.mgnet.customstructuresapi.manager;

import org.bukkit.Location;
import org.bukkit.Material;

public class BlockLocation {
	
	private int x; // Offset X Location
	private int y; // Offset Y Location
	private int z; // Offset Z Location
	private Material mat; // Offset Material Location. What? xD
	
	// Yes. this is the Constructor. Who could have known...
	public BlockLocation(int x, int y, int z, Material mat) {
		/**
		 * Constructor for RELATIVE Block Locations
		 */
		this.x = x; // Set Offset X
		this.y = y; // Set Offset Y
		this.z = z; // Why do i keep writing this?
		this.mat = mat; // Set Offs.. No Set Material
	}
	public int getX() {
		return x; // Give X Back
	}
	public int getY() {
		return y; // Give Y Back
	}
	public int getZ() {
		return z; // Give Z Back
	}
	public Material getMat() {
		return mat; // Give Material Back
	}
	
	// Method used to get a real Location using a Location and the Offset Locations.
	public Location getLoc(Location loc) {
		return new Location(loc.getWorld(), loc.getX() + x, loc.getY() + y, loc.getZ() + z);
	}
	
}
