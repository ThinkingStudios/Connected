package org.thinkingstudio.connected.sprite;

import java.util.Random;
import net.minecraft.block.BlockState;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;

import org.thinkingstudio.connected.config.RandomCTMConfig;

public class RandomSpriteProvider extends BaseSpriteProvider {

	public RandomSpriteProvider(Sprite[] connects, RandomCTMConfig config) {
		super(connects, config);
	}

	@Override
	public Sprite getSpriteForSide(Direction side, Direction upD, Direction leftD, BlockRenderView view, BlockState state, BlockPos pos, Random random) {
		return connects[random.nextInt(connects.length)];
	}

}
