package vt.smt.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import vt.smt.db.repositories.*;
import vt.smt.ent.game.GameCharacter;
import vt.smt.ent.net.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.LinkedList;
import java.util.List;

@Component (value = "registrationPageController" )
@ELBeanName(value = "registrationPageController")
public class RegistrationPageController {
    private String username;
    private String password;
    private String password2;
    // take hash from spring security

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    public String signUp(){
        if(usersRepository.findByLogin(username) != null){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!",
                            "Пользоатель с таким именем уже сущестует"));
            return null;
        }
        Users user = new Users();
        user.setPassword(encoder.encode(password));
        user.setLogin(username);
        user.setAuthType("register.jsf"); // role for the Spring security
        user.setRole("ROLE_USER");
        GameCharacter character = new GameCharacter();
        character.setName(user.getLogin());
        List<GameCharacter> characters = new LinkedList<>();
        characters.add(character);
        user.setGameCharacters(characters);
        user.setAccessLevel(0);
        character.setHealth(1000);
        character.setAttack(10);
        character.setExperience(1);
        character.setDefence(10);
        character.setRoses(0);
        character.setdRoses(0);
        character.setRhythm(1);
        List<GameCharacter> gameCharacters = new LinkedList<>();
        gameCharacters.add(character);
        user.setGameCharacters(gameCharacters);
        character.setOwner(user);
        character.setClazz("plain");
        // we need to have resource with name "default character"
        character.setImageResource(resourceRepository.findByName("default character"));
        usersRepository.save(user);
        characterRepository.save(character);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Успех",
                        "Вы зарегестрированы"));
        return "/index.jsf?faces-redirect=true";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public PasswordEncoder getEncoder() {
        return encoder;
    }

    public CharacterRepository getCharacterRepository() {
        return characterRepository;
    }

    public void setCharacterRepository(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public ResourceRepository getResourceRepository() {
        return resourceRepository;
    }

    public void setResourceRepository(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }
}
