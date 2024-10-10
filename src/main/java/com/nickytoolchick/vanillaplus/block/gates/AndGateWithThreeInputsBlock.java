package com.nickytoolchick.vanillaplus.block.gates;

public class AndGateWithThreeInputsBlock extends AbstractLogicGateBlock {
    public AndGateWithThreeInputsBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean calculateOutput(boolean input1, boolean input2, boolean input3) {
        return input1 && input2 && input3;
    }
}
