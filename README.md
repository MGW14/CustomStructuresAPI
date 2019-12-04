# CustomStructureAPI

Installation

Get the latest file from the server/plugins directory.
Place the file in your 1.14.4 spigot plugin folder.

Have fun!

Tested Versions: 
 - Paper 1.14.4 Build: 186
 - Paper 1.14.4 Build: 223

API usage:

How to add a Structure:
<code>
	CustomStructuresAPI.structureManager.addStructure(structure);
</code>

How to make an Instance of BlockLocation. (IMPORTANT! USE RELATIV POSITIONING!!!)
<code>
	BlockLocation b = new BlockLocation(-5, 1, 5, Material.SPONGE);
</code>

Take a look at the Javadoc
