package rocks.cleanstone.game.world.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import javax.annotation.Nullable;

import io.netty.buffer.ByteBuf;
import rocks.cleanstone.data.leveldb.LevelDBDataSource;
import rocks.cleanstone.game.world.region.chunk.Chunk;
import rocks.cleanstone.game.world.region.chunk.SimpleChunk;
import rocks.cleanstone.game.world.region.chunk.data.ChunkDataKeyFactory;
import rocks.cleanstone.game.world.region.chunk.data.StandardChunkDataType;
import rocks.cleanstone.game.world.region.chunk.data.block.BlockDataStorage;

public class LevelDBWorldDataSource extends LevelDBDataSource implements WorldDataSource {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final String worldID;
    private final boolean hasSkyLight;

    public LevelDBWorldDataSource(File worldDataFolder, String worldID) throws IOException {
        super(new File(worldDataFolder, worldID));
        this.worldID = worldID;

        // TODO read general world data (dimension, seed, etc)
        hasSkyLight = false;
    }

    @Nullable
    @Override
    public Chunk loadExistingChunk(int x, int y) {
        ByteBuf blocksKey = ChunkDataKeyFactory.create(x, y, StandardChunkDataType.BLOCKS);
        BlockDataStorage blockDataStorage;
        try {
            blockDataStorage = new BlockDataStorage(x, y, get(blocksKey), hasSkyLight);
        } catch (IOException e) {
            logger.error("Failed to load corrupted chunk block data at " + x + ":" + y + " in LevelDB '"
                    + worldID + "'", e);
            return null;
        }
        // TODO blockEntities, entities, biome state, version
        return new SimpleChunk(blockDataStorage.constructTable(), blockDataStorage, Collections.emptyList(), x, y);
    }

    @Override
    public void saveChunk(Chunk chunk) {
        // TODO
    }
}
