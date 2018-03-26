package vt.smt.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import vt.smt.db.repositories.*;
import vt.smt.ent.game.Ability;
import vt.smt.ent.game.CharacterAbility;
import vt.smt.ent.game.GameCharacter;
import vt.smt.ent.theory.Article;
import vt.smt.ent.theory.Course;
import vt.smt.ent.theory.Question;
import vt.smt.ent.theory.Test;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component(value = "theoryPageController")
@Scope(value = "session")
@ELBeanName(value = "theoryPageController")
public class TheoryPageController {

    private MenuModel menu;

    // Содержание активной статьи
    private String articleContent = "Помогает практике (:";
    private String articleTitle = "Теория музыки";

    private Map<String, List<String>> questions = new HashMap<>();
    
    private Map<String, String> questionContent = new HashMap<>();

    private Map<String, String> usrAnswer = new HashMap<>();

    private String buttonName = "";

//    private String weDontHaveTests = "";

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private AbilityRepository abilityRepository;

    @Autowired
    private CharacterAbilityRepository characterAbilityRespitory;

    private Test           articleTest;

    @PostConstruct
    public void initMenu(){
        menu = new DefaultMenuModel();

        for (Course course : courseRepository.findAll()) {
            DefaultSubMenu currentMenu = new DefaultSubMenu(course.getTitle());
            for (Article article : course.getArticles()) {
                DefaultMenuItem item = new DefaultMenuItem(article.getTitle());
                item.setParam("articleContent", article.getContent());
                item.setParam("articleTitle", article.getTitle());
                item.setCommand("#{theoryPageController.setArticleContentDynamic}");

                item.setUpdate(":test");
                currentMenu.addElement(item);
            }
            menu.addElement(currentMenu);
        }
    }

    public void setArticleContentDynamic(ActionEvent event){
        System.out.println("set article content dynamic");
        articleContent = ((MenuActionEvent)event).getMenuItem().getParams().get("articleContent").get(0);
        articleTitle   = ((MenuActionEvent)event).getMenuItem().getParams().get("articleTitle")  .get(0);
        buttonName      = "";
        articleTest = testRepository.findByTitle(articleTitle);

        questions.clear();
        questionContent.clear();
        usrAnswer.clear();
        System.out.println(articleTest);
        if(articleTest != null) {
            for (Question question : articleTest.getQuestions()) {
                List<String> q = new LinkedList<>();
                q.add(question.getWrong1());
                q.add(question.getWrong2());
                q.add(question.getWrong3());
                q.add(question.getAnswer());
                Collections.shuffle(q);
                questions.put(question.getQuestionId().toString(), q);
                questionContent.put(question.getQuestionId().toString(), question.getContent());
            }
        }
        event.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Проверить тест и, возможно, наградить
    public void passTheExam(){

        if(articleTest != null) {
            System.out.println("Пользователь попытался сдать экзамен. Ответ=" +
                usrAnswer.entrySet().stream().map(e -> e.getValue()).collect(Collectors.joining(", "))
                + "\nУспех = " +
                articleTest.getQuestions().stream().map(q -> q.getAnswer()).collect(Collectors.joining(","))
            );
            if(articleTest.getQuestions().stream()
                    .allMatch(q -> q.getAnswer().equals(usrAnswer.get(q.getQuestionId().toString())))) {
                Authentication authentication = // get it from the session
                        SecurityContextHolder.getContext().getAuthentication();
                regardUser(usersRepository.findByLogin(authentication.getName()).getGameCharacters().get(0),
                    articleTest.getScript().getScript()); // getScript. (см. setUpCourses.sql)
            }
            else {
                messageNotify("Хмм", usrAnswer.containsValue("окуни") ?
                        "~Стеклянные окуни- это Java EE~" :" Это неправильный ответ");
            }
        }
    }

    private void messageNotify(String head, String msg){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(head, msg));
    }

    private void regardUser(GameCharacter character, String rewardScript){
        messageNotify("Вы защитили теорию!", "В награду вы получаете новое умение!");
        Ability newAbility = abilityRepository.findByName(rewardScript);
        // Даём игроку новую абилку
        CharacterAbility character_ability = new CharacterAbility();
        character_ability.setAbility(newAbility);
        if(!character.getAbilities().contains(character_ability)) {
            character_ability.setAbility(newAbility);
            character_ability.setGameCharacter(character);
            character_ability.setPowerLevel(1);
            System.out.println("Новая способность:" + character_ability + character + newAbility);
            characterAbilityRespitory.save(character_ability);

            messageNotify(newAbility.getName(), newAbility.getDescription());
        }
        else
            messageNotify("Ах :)", "А ведь вы уже имеете способность " + newAbility.getName());
    }
    public MenuModel getMenu() {
        return menu;
    }

    public void setMenu(MenuModel menu) {
        this.menu = menu;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }
    public TestRepository getTestRepository() {
        return testRepository;
    }

    public void setTestRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Map<String, List<String>> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<String, List<String>> questions) {
        this.questions = questions;
    }

    public Map<String, String> getUsrAnswer() {
        return usrAnswer;
    }

    public void setUsrAnswer(Map<String, String> usrAnswer) {
        this.usrAnswer = usrAnswer;
    }
    
    public Map<String, String> getQuestionContent() {
        return questionContent;
    }
    
    public void setQuestionContent(Map<String, String> q) {
        questionContent = q;
    }
    
    public List<String> getQuestionIds() {
        return questionContent.keySet().stream().map(i -> i.toString()).collect(Collectors.toList());
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

}
