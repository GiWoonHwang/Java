package io.dustin.api.usecase;

import io.dustin.api.command.UserCommand;
import io.dustin.domain.user.model.entity.User;
import io.dustin.domain.user.model.entity.dto.SignUpDto;
import io.dustin.domain.user.service.WriteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteUserUseCase {
    @Autowired
    WriteUserService writeUserService;

    public SignUpDto execute(UserCommand command) {
        User user = User.builder()
                        .id(command.id())
                        .pwd(command.pwd())
                        .email(command.pwd())
                        .build();
        writeUserService.signUp(user);
        return new SignUpDto(user.getId(), user.getEmail());
    }



}
