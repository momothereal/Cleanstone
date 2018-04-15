package rocks.cleanstone.net.packet.minecraft.outbound;

import rocks.cleanstone.net.packet.PacketType;
import rocks.cleanstone.net.packet.OutboundPacket;
import rocks.cleanstone.net.packet.minecraft.MinecraftOutboundPacketType;

public class SpawnExperienceOrbPacket extends OutboundPacket {

    private final int entityID;
    private final double x;
    private final double y;
    private final double z;
    private final short count;

    public SpawnExperienceOrbPacket(int entityID, double x, double y, double z, short count) {
        this.entityID = entityID;
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
    }

    public int getEntityID() {
        return entityID;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public short getCount() {
        return count;
    }

    @Override
    public PacketType getType() {
        return MinecraftOutboundPacketType.SPAWN_EXPERIENCE_ORB;
    }
}