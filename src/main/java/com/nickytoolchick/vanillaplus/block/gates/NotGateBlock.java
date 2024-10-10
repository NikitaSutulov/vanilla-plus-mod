package com.nickytoolchick.vanillaplus.block.gates;

public class NotGateBlock extends AbstractLogicGateBlock {
    public NotGateBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean calculateOutput(boolean input1, boolean input2, boolean input3) {
        return !input3;
    }
}
