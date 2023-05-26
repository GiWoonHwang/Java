package dustin.apps.board.api.view;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class ViewAnswerController {

    @GetMapping("/modify")
    public String modifyAnswer(Model model, Principal principal) {
        return "answer_form";
    }

}
