package baseball.controller;

import baseball.controller.handlers.InitModeHandler;
import baseball.controller.handlers.ModeHandler;
import baseball.model.BaseBallModel;
import baseball.view.BaseBallView;

public class SimpleBaseBallController implements BaseBallController {
    private ModeHandler currentHandler;

    public SimpleBaseBallController(BaseBallModel model, BaseBallView view) {
        this.currentHandler = new InitModeHandler(model,view,this);
    }

    @Override
    public void start() {
        while(this.currentHandler.isRunning()){
            this.currentHandler.process();
        }
    }

    @Override
    public void setHandler(final ModeHandler handler){
        this.currentHandler = handler;
    }
}
