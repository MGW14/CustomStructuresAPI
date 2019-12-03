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
[CODE]
	CustomStructuresAPI.structureManager.addStructure(structure);
[/CODE]

How to make an Instance of BlockLocation. (IMPORTANT! USE RELATIV POSITIONING!!!)
[CODE]
	BlockLocation b = new BlockLocation(-5, 1, 5, Material.SPONGE);
[/CODE]

Take a look at the Javadoc