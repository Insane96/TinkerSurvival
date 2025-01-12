package tinkersurvival.common;

import java.util.Collections;
import java.util.Objects;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.registries.ForgeRegistries;

import tinkersurvival.TinkerSurvival;

public final class TagManager {

    public static final class Items {
        public static final TagKey<Item> FLINT_KNAPPABLE = create("flint_knappable");
        public static final TagKey<Item> PICKAXE_TOOLS = create("pickaxe_tools");
        public static final TagKey<Item> AXE_TOOLS = create("axe_tools");
        public static final TagKey<Item> SAW_TOOLS = create("saw_tools");
        public static final TagKey<Item> SHOVEL_TOOLS = create("shovel_tools");
        public static final TagKey<Item> HOE_TOOLS = create("hoe_tools");
        public static final TagKey<Item> KNIFE_TOOLS = create("knife_tools");
        public static final TagKey<Item> SHARP_TOOLS = create("sharp_tools");
        public static final TagKey<Item> ROCK = create("rock");
        public static final TagKey<Item> SAW_PARTS = create("saw_parts");
        public static final TagKey<Item> BANDAGES = create("bandages");
        public static final TagKey<Item> SAW_BLADE_CAST = getItemTag(TinkerSurvival.MODID, "casts/multi_use/saw_blade");
        public static final TagKey<Item> SAW_BLADE_CAST_SINGLE = getItemTag(TinkerSurvival.MODID, "casts/single_use/saw_blade");

        // Mod Integration
        // Fruit Trees
        public static final TagKey<Item> CHERRY_LOGS = create("cherry_logs");
        public static final TagKey<Item> CITRUS_LOGS = create("citrus_logs");

        // Biome Makeover
        public static final TagKey<Item> BMO_ANCIENT_OAK_LOGS = create("ancient_oak_logs");
        public static final TagKey<Item> BMO_BLIGHTED_BALSA_LOGS = create("blighted_balsa_logs");
        public static final TagKey<Item> BMO_SWAMP_CYPRESS_LOGS = create("swamp_cypress_logs");
        public static final TagKey<Item> BMO_WILLOW_LOGS = create("bmo_willow_logs");

        // Biomes O' Plenty
        public static final TagKey<Item> BOP_CHERRY_LOGS = create("bop_cherry_logs");
        public static final TagKey<Item> BOP_DEAD_LOGS = create("dead_logs");
        public static final TagKey<Item> BOP_FIR_LOGS = create("fir_logs");
        public static final TagKey<Item> BOP_HELLBARK_LOGS = create("hellbark_logs");
        public static final TagKey<Item> BOP_JACARANDA_LOGS = create("jacaranda_logs");
        public static final TagKey<Item> BOP_MAGIC_LOGS = create("magic_logs");
        public static final TagKey<Item> BOP_MAHOGANY_LOGS = create("mahogany_logs");
        public static final TagKey<Item> BOP_PALM_LOGS = create("palm_logs");
        public static final TagKey<Item> BOP_REDWOOD_LOGS = create("redwood_logs");
        public static final TagKey<Item> BOP_UMBRAN_LOGS = create("umbran_logs");
        public static final TagKey<Item> BOP_WILLOW_LOGS = create("willow_logs");

        // Quark
        public static final TagKey<Item> QUARK_AZALEA_LOGS = create("azalea_logs");
        public static final TagKey<Item> QUARK_BLOSSOM_LOGS = create("blossom_logs");

        // All You Can Eat
        public static final TagKey<Item> AYCE_HAZEL_LOGS = create("hazel_logs");

        // Tinkers' Construct
        public static final TagKey<Item> TCON_BLOODSHROOM_LOGS = create("bloodshroom_logs");
        public static final TagKey<Item> TCON_GREENHEART_LOGS = create("greenheart_logs");
        public static final TagKey<Item> TCON_SKYROOT_LOGS = create("skyroot_logs");

        // Water Source
        public static final TagKey<Item> WS_PALM_TREE_LOGS = create("palm_tree_logs");

        // Botania
        public static final TagKey<Item> BOTANIA_DREAMWOOD_LOGS = create("dreamwood_logs");
        public static final TagKey<Item> BOTANIA_LIVINGWOOD_LOGS = create("livingwood_logs");

        // IE
        public static final TagKey<Item> IE_TREATED_WOOD = forgeTag("treated_wood");

        private static TagKey<Item> create(String id) {
            return Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).createOptionalTagKey(identifier(id), Collections.emptySet());
        }

        private static TagKey<Item> forgeTag(String name) {
            return Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).createOptionalTagKey(forgeLoc(name), Collections.emptySet());
        }

        private static TagKey<Item> getItemTag(String modid, String name) {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(modid, name));
        }
    }

    public static final class Blocks {
        public static final TagKey<Block> ALWAYS_BREAKABLE = create("always_breakable");
        public static final TagKey<Block> ALWAYS_DROPS = create("always_drops");
        public static final TagKey<Block> LOOSE_ROCK_PLACEABLE_ON = create("loose_rock_placeable_on");
        public static final TagKey<Block> LOOSE_ROCKS = create("loose_rocks");
        public static final TagKey<Block> FIBER_PLANTS = create("fiber_plants");

        private static TagKey<Block> create(String id) {
            return Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).createOptionalTagKey(identifier(id), Collections.emptySet());
        }

        private static TagKey<Block> forgeTag(String name) {
            return Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).createOptionalTagKey(forgeLoc(name), Collections.emptySet());
        }
    }

    public static ResourceLocation identifier(String path) {
        return new ResourceLocation(TinkerSurvival.MODID, path);
    }

    public static ResourceLocation forgeLoc(String path) {
        return new ResourceLocation("forge", path);
    }

}
