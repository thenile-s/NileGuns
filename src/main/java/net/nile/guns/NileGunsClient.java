package net.nile.guns;

import java.io.IOException;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;

@Environment(EnvType.CLIENT)
public class NileGunsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(NileGuns.BULLET, (dispatcher, context) -> {
            return new BulletEntityRenderer(dispatcher);
        });
        
        //I couldn't get the client package registry to register my handler, perhaps because
        //I provided an invalid Identifier?
        //Using a mixin instead
        //ClientSidePacketRegistry.INSTANCE.register(new Identifier(NileGuns.modid), NileGunsClient::spawnEntity);
    }

    // private static void spawnEntity(PacketContext pc, PacketByteBuf buffer) {
    //     // buffer
    //     NileGuns.logger.info("Here 2");
    //     try {
    //         EntitySpawnS2CPacket info = new EntitySpawnS2CPacket();
    //         info.read(buffer);
    //         //Registry.ENTITY_TYPE.get(info.getEntityTypeId());
    //         pc.getTaskQueue().execute(() -> {
    //             ((ClientWorld) pc.getPlayer().world).addEntity(info.getId(), new BulletEntity(NileGuns.BULLET, (ClientWorld) pc.getPlayer().world));
    //             NileGuns.logger.info("Here 1");
    //         });
            
    //     } catch (IOException e) {
    //         NileGuns.logger.error("Exception when spawning entity client-side. ", e);
    //     }
    // }
}
