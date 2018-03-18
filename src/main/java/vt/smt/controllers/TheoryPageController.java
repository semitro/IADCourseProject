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

        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");

        DefaultMenuItem item = new DefaultMenuItem("External");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("ui-icon-home");
        firstSubmenu.addElement(item);

        menu.addElement(firstSubmenu);


    }

    public MenuModel getMenu() {
        return menu;
    }

    public void setMenu(MenuModel menu) {
        this.menu = menu;
    }

}
