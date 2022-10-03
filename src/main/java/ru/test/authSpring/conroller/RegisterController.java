package ru.test.authSpring.conroller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.test.authSpring.request.RegisterRequest;
import ru.test.authSpring.service.RegisterService;

@RestController
@RequestMapping(path = "api/v1/register")
@AllArgsConstructor
public class RegisterController {

    private RegisterService registerService;

    public String register(@RequestBody RegisterRequest request){
        return registerService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registerService.confirmToken(token);
    }
}
