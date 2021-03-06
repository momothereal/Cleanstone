package rocks.cleanstone.data;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import rocks.cleanstone.net.utils.ByteBufUtils;

public class EnumCodec<E extends Enum<E>> implements Codec<E, ByteBuf> {

    private final Class<E> enumClass;

    public EnumCodec(Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public E deserialize(ByteBuf data) throws IOException {
        int index = ByteBufUtils.readVarInt(data);
        return enumClass.getEnumConstants()[index];
    }

    @Override
    public ByteBuf serialize(E value) {
        ByteBuf buf = Unpooled.buffer();
        ByteBufUtils.writeVarInt(buf, value.ordinal());
        return buf;
    }
}
