package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    //junit 5부터는 public설정 따로 안해주어도 상관 없다
    @Test
    @DisplayName("모든 spring Bean출력")
    void findAllBean() {
        //bean정의된 이름을 다 등록
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        //iter하면 나온다
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "object = " + bean);
        }

    }

    //우리가 만든 것만 나온다.
    @Test
    @DisplayName("애플리케이션 Bean출력")
    void findApplicationAllBean() {
        //bean정의된 이름을 다 등록
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        //iter하면 나온다
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            /*
            * Role ROLE_application : 직접 등록한 애플리케이션 빈
            * ROLE ROLE_infRASTRUCture : 스프링이 내부에서 사용하는 빈
            * */
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "object = " + bean);
            }
        }
        //spring bean을 조회하는 가장 기본적인 조회방법 => getBean 사용하기

    }
}
