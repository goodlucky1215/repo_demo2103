package design.duck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiDuckSimulation {

	public static void main(String[] args) {
		//여기서 그 객체들을 가져온다
		ApplicationContext context = new ClassPathXmlApplicationContext("design\\duck\\duckBean.xml");
		//myDuck이라는 name을 가진애를 가져오고 그 클래스를 넣어준거지 -이게 mallardduck이지
		Duck myDuck = (Duck)context.getBean("myDuck");
		myDuck.performQuack();
		myDuck.performFly();
		//candidate 상태 : (16->17)로 가는 이 구간 - garbage값이 되는 대상이 된다. 그게 바로 candidate상태가 된다는 것임.
		myDuck = null;
		myDuck = new MallardDuck();//인스턴스화해서 보여주므로써 위랑 결과값이 같다는 것을 보여주고 있다.
		//12번과 17번의 MallardDuck()은 완전히 다름. 12번은 관리를 받고 17번은 관리를 받지 못한다.
		//ApplicationContext랑 BeanFactory는 관리를 해준다. 그래서 12번이 관리를 받고 있는 거야!
		myDuck.performQuack();
		myDuck.performFly();		
	}

}
