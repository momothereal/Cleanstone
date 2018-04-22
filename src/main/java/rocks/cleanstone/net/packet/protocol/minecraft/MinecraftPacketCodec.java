package rocks.cleanstone.net.packet.protocol.minecraft;

import rocks.cleanstone.net.packet.protocol.PacketCodec;
import rocks.cleanstone.net.packet.protocol.ProtocolState;

public interface MinecraftPacketCodec extends PacketCodec {
    int getProtocolPacketID();
    ProtocolState getProtocolState();
}
