package vt.smt.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vt.smt.ent.game.GameCharacter;
import vt.smt.util.ResourceManager;

import javax.faces.context.FacesContext;

/*
 * Бины создаёт Spring, судя по всему (аннотации JSF-бинодела закомменчены)
 */
//@ManagedBean(eager = true)
//@ApplicationScoped - не нужны
@Join(path = "/", to = "/main.jsf")
@Component(value = "characterPageController") // Indicates that an annotated class is a "component".
// Such classes are considered as candidates for auto-detection
// when using annotation-based configuration and classpath scanning. (spring)
@Scope(value = "session")
@ELBeanName(value = "characterPageController")  // EL - expression language - как он зоётся из JSF
public class CharacterPageController {

    private GameCharacter character;

    private StreamedContent characterImage;

//    private StreamedContent itemImage1;
//    private StreamedContent itemImage2;
//    private StreamedContent itemImage3;
//    private StreamedContent itemImage4;
//    private StreamedContent itemImage5;
//    private StreamedContent itemImage6;

    public CharacterPageController(){
        // take it from the session
        character = (GameCharacter) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("GameCharacter");
        loadImages();

    }

    private void loadImages(){
        characterImage = new DefaultStreamedContent(
                ResourceManager.loadResource(character.getImageResource()),"image/png");
//        for (CharacterItem item : character.getItems()) {
//            switch (item.getSlot()){
//                case 1:{
//                    itemImage1 =
//                    break;
//                }
//            }
//        }
    }
    public GameCharacter getCharacter() {
        return character;
    }

    public StreamedContent getCharacterImage() {
        return characterImage;
    }

    public void setCharacterImage(StreamedContent characterImage) {
        this.characterImage = characterImage;
    }

    public void setCharacter(GameCharacter character) {
        this.character = character;
    }
}
