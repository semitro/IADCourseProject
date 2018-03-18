package vt.smt.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vt.smt.db.repositories.ArticleRepository;
import vt.smt.db.repositories.CourseRepository;
import vt.smt.ent.theory.Article;
import vt.smt.ent.theory.Course;

import javax.annotation.PostConstruct;

@Component(value = "theoryPageController")
@Scope(value = "session")
@ELBeanName(value = "theoryPageController")
public class TheoryPageController {

    private MenuModel menu;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostConstruct
    public void initMenu(){
        menu = new DefaultMenuModel();

        for (Course course : courseRepository.findAll()) {
            DefaultSubMenu currentMenu = new DefaultSubMenu(course.getTitle());
            for (Article article : course.getArticles()) {
                DefaultMenuItem item = new DefaultMenuItem(article.getTitle());
                item.setUrl("www.xui.com");
                currentMenu.addElement(item);
            }
            menu.addElement(currentMenu);
        }
    }

    public MenuModel getMenu() {
        return menu;
    }

    public void setMenu(MenuModel menu) {
        this.menu = menu;
    }

}
