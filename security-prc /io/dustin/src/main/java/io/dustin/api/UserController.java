package io.dustin.api;

import io.dustin.api.command.UserCommand;
import io.dustin.api.query.UserQuery;
import io.dustin.api.usecase.ReadUserUseCase;
import io.dustin.api.usecase.WriteUserUseCase;
import io.dustin.domain.user.model.entity.dto.SignInDto;
import io.dustin.domain.user.model.entity.dto.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final WriteUserUseCase writeUserUseCase;
    private final ReadUserUseCase readUserUseCase;

    @PostMapping("/signup")
    public SignUpDto sighUp(@RequestBody UserCommand command) {
        return writeUserUseCase.execute(command);
    }

    @PostMapping("/signin")
    public SignInDto signIn(@RequestBody UserQuery query) {
        return readUserUseCase.execute(query);
    }

}
