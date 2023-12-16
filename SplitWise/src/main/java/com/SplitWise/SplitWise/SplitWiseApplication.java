package com.SplitWise.SplitWise;

import com.SplitWise.SplitWise.Exceptions.UserNotFoundException;
import com.SplitWise.SplitWise.commands.CommandExecutor;
import com.SplitWise.SplitWise.commands.SettleUpCommand;
import com.SplitWise.SplitWise.commands.UpdateProfileCommand;
import com.SplitWise.SplitWise.controllers.SettleUpController;
import com.SplitWise.SplitWise.controllers.UpdateProfileController;
import com.SplitWise.SplitWise.dtos.SettleUpGroupRequestdto;
import com.SplitWise.SplitWise.dtos.SettleUpGroupResponsedto;
import com.SplitWise.SplitWise.dtos.UpdateProfileRequestdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;
import java.lang.annotation.Annotation;


@SpringBootApplication
@EnableJpaAuditing
public class SplitWiseApplication implements CommandLineRunner {

	@Autowired
	private CommandExecutor commandExecutor;

	@Autowired
	private SettleUpCommand settleUpCommand;

	@Autowired
	private UpdateProfileCommand updateProfileCommand;

	@Autowired
	private SettleUpController settleUpController;

	private Scanner scanner =new Scanner(System.in);

	public static void main(String[] args) {

		SpringApplication.run(SplitWiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SettleUpGroupRequestdto settleUpGroupRequestdto = new SettleUpGroupRequestdto();
		settleUpGroupRequestdto.setGroup_id(1);
		SettleUpGroupResponsedto settleUpGroupResponsedto=  settleUpController.settleUpGroup(settleUpGroupRequestdto);
		System.out.println(settleUpGroupResponsedto);
//		this.commandExecutor.addCommand(settleUpCommand);
//		this.commandExecutor.addCommand(updateProfileCommand);
//		while(true){
//			String input = this.scanner.nextLine();
//			commandExecutor.execute(input);
//		}
	}

}
