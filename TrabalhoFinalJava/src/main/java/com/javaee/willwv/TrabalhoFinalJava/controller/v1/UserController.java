package com.javaee.willwv.TrabalhoFinalJava.controller.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.willwv.TrabalhoFinalJava.domain.Acao;
import com.javaee.willwv.TrabalhoFinalJava.domain.RMQMessage;
import com.javaee.willwv.TrabalhoFinalJava.domain.User;
import com.javaee.willwv.TrabalhoFinalJava.services.MessageService;
import com.javaee.willwv.TrabalhoFinalJava.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("This id User API")
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
	public static final String BASE_URL = "/api/v1/users";
	
	private final UserService userService;
	private final MessageService messageService;
	
	public UserController(UserService userService, MessageService messageService) {
		this.userService = userService;
		this.messageService = messageService;
	}
	
	@ApiOperation(value = "View List of Users", notes = "These endpoint will return all users")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<User> getAll(){		
		return userService.getAllUsers();
	}
	
	/*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String sendNewMessage(@RequestBody RMQMessage message){
		messageService.sendMessage(message);
        return "Message sent";
    }*/
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarAcao(@RequestBody Acao acao){
		messageService.sendMessage(acao);
        return "Message sent";
    }
}
