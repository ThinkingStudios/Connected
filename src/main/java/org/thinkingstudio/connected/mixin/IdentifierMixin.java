package org.thinkingstudio.connected.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.Identifier;

import org.thinkingstudio.connected.Connected;

@Mixin(Identifier.class)
public class IdentifierMixin {
	@Inject(method = "isPathValid(Ljava/lang/String;)Z", at = @At("HEAD"), cancellable = true)
	private static void overrideIdentifierRestrictions(CallbackInfoReturnable<Boolean> callback) {
		if(Connected.overrideIdentifierCharRestriction && Thread.currentThread() == Connected.identifierOverrideThread) {
			callback.setReturnValue(true);
		}
	}
}
