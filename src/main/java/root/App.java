package root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import root.gui.GUI1;
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //GUI1.showMainMenu();
        SpringApplication.run(App.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        GUI1 gui1 = context.getBean(GUI1.class);
        gui1.showMainMenu();

    }



}

