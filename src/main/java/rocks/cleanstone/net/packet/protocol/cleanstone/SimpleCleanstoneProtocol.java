package rocks.cleanstone.net.packet.protocol.cleanstone;

import rocks.cleanstone.net.packet.Packet;
import rocks.cleanstone.net.packet.PacketTypeRegistry;
import rocks.cleanstone.net.packet.SimplePacketTypeRegistry;
import rocks.cleanstone.net.packet.cleanstone.CleanstoneInboundPacketType;
import rocks.cleanstone.net.packet.cleanstone.CleanstoneOutboundPacketType;
import rocks.cleanstone.net.packet.protocol.ClientProtocolLayer;
import rocks.cleanstone.net.packet.protocol.PacketCodec;
import rocks.cleanstone.net.packet.protocol.Protocol;

public class SimpleCleanstoneProtocol implements Protocol {

    private PacketTypeRegistry registry;

    public void init() {
        registry = new SimplePacketTypeRegistry();
        registry.registerPacketType(CleanstoneOutboundPacketType.values());
        registry.registerPacketType(CleanstoneInboundPacketType.values());
    }

    @Override
    public PacketCodec getPacketCodec(Class<? extends Packet> packet, ClientProtocolLayer clientLayer) {
        return null;
    }

    @Override
    public PacketTypeRegistry getPacketTypeRegistry() {
        return registry;
    }

    @Override
    public int translateInboundPacketID(int clientPacketID, ClientProtocolLayer clientLayer) {
        return clientPacketID;
    }

    @Override
    public int translateOutboundPacketID(int serverPacketID, ClientProtocolLayer clientLayer) {
        return serverPacketID;
    }
}
