package org.thinkingstudio.connected.mixin;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import org.thinkingstudio.connected.Connected;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.resource.ReloadableResourceManager;
import net.minecraft.resource.ReloadableResourceManagerImpl;
import net.minecraft.resource.ResourcePack;
import net.minecraft.resource.ResourceReloadMonitor;
import net.minecraft.util.Unit;

import org.thinkingstudio.connected.resource.CBTResourcePack;

@Mixin(ReloadableResourceManagerImpl.class)
public abstract class ReloadableResourceManagerImplMixin implements ReloadableResourceManager {
	@Shadow
	public abstract void addPack(ResourcePack resourcePack);

	@Inject(method = "beginMonitoredReload", at = @At(value = "RETURN", shift = At.Shift.BEFORE))
	private void injectCBTPack(Executor prepareExecutor, Executor applyExecutor, CompletableFuture<Unit> initialStage, List<ResourcePack> packs, CallbackInfoReturnable<ResourceReloadMonitor> cir) {
		Connected.RESOURCE_PACK_PRIORITY_MAP.clear();
		for(int i = 0; i < packs.size(); i++) {
			Connected.RESOURCE_PACK_PRIORITY_MAP.put(packs.get(i).getName(), i);
		}
		this.addPack(Connected.resourcePack = new CBTResourcePack(this));
	}

}
