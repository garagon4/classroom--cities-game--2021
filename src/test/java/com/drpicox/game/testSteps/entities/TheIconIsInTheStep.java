package com.drpicox.game.testSteps.entities;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.components.resourceds.ResourcedTestView;
import org.springframework.stereotype.Component;

@Component
public class TheIconIsInTheStep extends AbstractPostLineStep {

    private final ResourcedTestView  resourcedTestView;

    public TheIconIsInTheStep(EntityTestView entityTestView, ResourcedTestView resourcedTestView) {
        this.resourcedTestView = resourcedTestView;
    }

    @Override
    protected String getRegex() {
        return "The \"([^\"]+)\" icon is (not )?in the \"([^\"]+)\" \"([^\"]+)\" \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
//        System.out.println(Arrays.toString(match));
//        var type  = match[1];
//        var present  = match[2];
//        var player  = match[3];
//        var entity  = match[4];
//        var name  = match[5];
//        var value = resourcedTestView.getResourceCount(type);
//        assertThat(value>0).isEqualTo(present == null);

    }
}
