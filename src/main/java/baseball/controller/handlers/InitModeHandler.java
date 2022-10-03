package baseball.controller.handlers;

import baseball.controller.BaseBallController;
import baseball.model.BaseBallModel;
import baseball.view.BaseBallView;

public class InitModeHandler implements ModeHandler {

    private final BaseBallModel model;
    private final BaseBallView view;
    private final BaseBallController controller;

    public InitModeHandler(BaseBallModel model, BaseBallView view, BaseBallController controller) {
        this.model = model;
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void process() {
        this.model.init();
        this.controller.setHandler(new InputModeHandler(model,view,controller));
    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
