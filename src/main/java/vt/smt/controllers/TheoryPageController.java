package vt.smt.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vt.smt.db.repositories.CourseRepository;
import vt.smt.db.repositories.TestRepository;
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
import java.util.LinkedList;
import java.util.List;

@Component(value = "theoryPageController")
@Scope(value = "session")
@ELBeanName(value = "theoryPageController")
public class TheoryPageController {

    private MenuModel menu;

    // Содержание активной статьи
    private String articleContent = "Помогает практике (:";
    private String articleTitle = "Теория музыки";

    private List<String> questions = new LinkedList<>();

    private String usrAnswer = "";

    private String buttonName = "Сдать экзамен";

//    private String weDontHaveTests = "";

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TestRepository testRepository;
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

                item.setUpdate("test:examButton");
                currentMenu.addElement(item);
            }
            menu.addElement(currentMenu);
        }
    }
    public void setArticleContentDynamic(ActionEvent event){
        System.out.println("set article content dynamic");
        articleContent = ((MenuActionEvent)event).getMenuItem().getParams().get("articleContent").get(0);
        articleTitle   = ((MenuActionEvent)event).getMenuItem().getParams().get("articleTitle")  .get(0);
//        weDontHaveTests = "";
        buttonName      = "";
        articleTest = testRepository.findByTitle(articleTitle);
        if(articleTest == null) {
//            weDontHaveTests = "Извините, тест для данного раздела ещё не придуман!";
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Извините", "Тест для данного раздела" +
                    "находится в разработке"));
        }
        else
            buttonName = "Ответить!";
        event.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void passTheExam(){
//        weDontHaveTests = "";
//        if(buttonName.equals("Сдать экзамен")){
            questions.clear();
            System.out.println(articleTest);
            for (Question question : articleTest.getQuestions()) {
                questions.add(question.getWrong1());
                questions.add(question.getWrong2());
                questions.add(question.getWrong3());
                questions.add(question.getAnswer());
            }
//        }
        System.out.println("Пользователь попытался сдать экзамен. Ответ=" + usrAnswer
                + "Успех = " + articleTest.getQuestions().get(0).getAnswer().equals(usrAnswer));
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

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public String getUsrAnswer() {
        return usrAnswer;
    }

    public void setUsrAnswer(String usrAnswer) {
        this.usrAnswer = usrAnswer;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

//    public String getWeDontHaveTests() {
//        return weDontHaveTests;
//    }
//
//    public void setWeDontHaveTests(String weDontHaveTests) {
//        this.weDontHaveTests = weDontHaveTests;
//    }

}
