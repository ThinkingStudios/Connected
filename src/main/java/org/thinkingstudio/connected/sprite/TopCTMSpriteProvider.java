package org.thinkingstudio.connected.sprite;

import java.util.Random;
import net.minecraft.block.BlockState;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;

import org.thinkingstudio.connected.config.ConnectingCTMConfig;

public class TopCTMSpriteProvider extends ConnectingSpriteProvider {
	
	public TopCTMSpriteProvider(Sprite[] connects, ConnectingCTMConfig<?> config) {
		super(connects, config);
	}

	@Override
	public Sprite getSpriteForSide(Direction side, Direction upD, Direction leftD, BlockRenderView view, BlockState state, BlockPos pos, Random random) {
		return testUp(view, upD, pos, state) ? connects[0] : null;
	}
}
