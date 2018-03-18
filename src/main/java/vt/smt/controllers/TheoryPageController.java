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
import vt.smt.ent.theory.Article;
import vt.smt.ent.theory.Course;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

@Component(value = "theoryPageController")
@Scope(value = "session")
@ELBeanName(value = "theoryPageController")
public class TheoryPageController {

    private MenuModel menu;

    // Содержание активной статьи
    private String articleContent = "";

    private String articleTitle = "";

    @Autowired
    private CourseRepository courseRepository;

    @PostConstruct
    public void initMenu(){
        menu = new DefaultMenuModel();

        for (Course course : courseRepository.findAll()) {
            DefaultSubMenu currentMenu = new DefaultSubMenu(course.getTitle());
            for (Article article : course.getArticles()) {
                DefaultMenuItem item = new DefaultMenuItem(article.getTitle());
                item.setCommand("#{theoryPageController.setArticleContentDynamic}");
                item.setParam("articleContent", article.getContent());
                item.setParam("articleTitle", article.getTitle());
                item.setUpdate("articleContent articleTitle");

                currentMenu.addElement(item);
            }
            menu.addElement(currentMenu);
        }
    }

    public void setArticleContentDynamic(ActionEvent event){
        articleContent = ((MenuActionEvent)event).getMenuItem().getParams().get("articleContent").get(0);
        articleTitle   = ((MenuActionEvent)event).getMenuItem().getParams().get("articleTitle").get(0);
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

}
