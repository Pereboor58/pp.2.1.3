import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());
        HelloWorld bean2 =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean2.getMessage());

        System.out.println("Singleton: " + (bean==bean2));

        Cat catBean = applicationContext.getBean("cat",Cat.class);
        System.out.println(catBean.getSayCat());
        Cat catBean2 = applicationContext.getBean("cat",Cat.class);
        System.out.println(catBean2.getSayCat());

        System.out.println("Prototype: " + (catBean==catBean2));
    }
}