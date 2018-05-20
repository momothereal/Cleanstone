package rocks.cleanstone.game.block;

import com.google.common.base.Preconditions;

import java.util.Collection;
import java.util.HashSet;

import rocks.cleanstone.game.material.Material;

/**
 * An immutable state of a block containing its material and metadata
 *
 * Blocks using metadata should extend this class to create a wrapper around the inconvenient metadata field
 */
public class BlockState {

    private static final Collection<BlockState> CACHED_STATES = new HashSet<>();

    private final Material material;
    private final byte metadata;

    protected BlockState(Material material, byte metadata) {
        Preconditions.checkNotNull(material, "material cannot be null");
        Preconditions.checkArgument(metadata >= 0 && metadata < 16, "metadata out of range");
        this.material = material;
        this.metadata = metadata;
    }

    public static BlockState of(Material material, byte metadata) {
        return CACHED_STATES.stream().filter(b -> b.getMaterial().equals(material) && b.getMetadata() == metadata)
                .findFirst().orElseGet(() -> {
                    BlockState newState = new BlockState(material, metadata);
                    CACHED_STATES.add(newState);
                    return newState;
                });
    }

    public static BlockState of(Material material) {
        return of(material, (byte) 0);
    }

    public final Material getMaterial() {
        return material;
    }

    public final byte getMetadata() {
        return metadata;
    }
}