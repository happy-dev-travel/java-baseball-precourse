package baseball.controller;

import baseball.model.BaseBallModel;
import baseball.view.BaseBallView;

public class SimpleBaseBallController implements BaseBallController{

    private final BaseBallModel model;
    private final BaseBallView view;

    public SimpleBaseBallController(BaseBallModel model, BaseBallView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void start() {
        this.model.init();
    }
}
