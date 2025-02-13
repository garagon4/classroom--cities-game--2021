package com.drpicox.game.testSteps.login;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

@Component
public class EnterAsPasswordStep extends AbstractPostLineStep {

    private LoginTestView loginTestView;

    public EnterAsPasswordStep(LoginTestView loginTestView) {
        this.loginTestView = loginTestView;
    }

    @Override
    protected String getRegex() {
        return "Enter \"([^\"]+)\" as password";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var password = match[1];
        loginTestView.enterPassword(password);
    }
}
