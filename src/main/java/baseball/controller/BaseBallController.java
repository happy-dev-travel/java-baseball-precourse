package baseball.controller;

import baseball.controller.handlers.ModeHandler;

public interface BaseBallController {
    void start();
    void setHandler(final ModeHandler handler);
}
