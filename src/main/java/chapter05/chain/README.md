## 책임 연쇄 (Chain of Responsibility)

### 목적
메시지를 보내는 객체와 이를 받아 처리하는 객체들 간의 결합도를 없애기 위한 패턴

### 동기
한 객체에게 보낸 메시지가 내부적으로 연결된 다른 객체에게 자동으로 전달되며, 메시지를 받은 객체는 런타임 조건에 따라 메시지를 처리할 것인지 결정한다

### 활용
- 하나 이상의 객체가 요청을 처리해야 하고, 그 요청 처리자 중 어떤 것이 선행자(priori)인지 모를 때. 처리자가 자동으로 확정되어야 한다
- 메시지를 받을 객체를 명시하지 않은 채 여러 객체 중 하나에게 처리를 여청하고 싶을 때
- 요청을 처리할 수 있는 객체 집합이 동적으로 정의되어야 할 때

### 이점
- 객체 간의 행동적 결합도가 적어진다: 다른 객체가 어떻게 요청을 처리하는지 몰라도되며 자신과 연결된 단 하나의 후보 객체만 알면 되므로 객체들 간의 상호작용 과정을 단순화 시킨다
- 객체에게 책임을 할당하는 데 유연성을 높일 수 있다: 객체의 책임을 여러 객체에게 분산시킬 수 있으므로 런타임에 객체 연결 고리를 변경하거나 추가하여 책임을 변경하거나 확장할 수 있다

### 단점
- 메시지 수신이 보장되지 않는다: 요청이 반드시 수행된다는 보장이 없다

### 구조
- Handler: 요청을 처리하는 인터페이스를 정의하고, 후속 처리자와 연결을 구현. 즉, 연결 고리에 연결된 다음 객체에게 다시 메시지를 보낸다
- ConcreteHandler: 자신이 처리할 행동이 있으면 처리하고, 그렇지 않으면 후속 처리자에 다시 처리를 요청한다
- Client: ConcreteHandler 객체에게 필요한 요청을 보낸다
> 사용자는 처리를 요청하고, 이 처리 요청은 실제로 그 요청을 받을 책임이 있는 ConcreteHandler 객체를 만날 때까지 정의된 연결 고리를 따라서 계속 전달된다

### 예제코드 (Ref. https://www.journaldev.com/1617/chain-of-responsibility-design-pattern-in-java)
- Handler: DispenseChain
```
public interface DispenseChain {
	void setNextChain(DispenseChain nextChain);
	void dispense(Currency cur);
}
```

- ConcreteHandler: Dollar50Dispenser, Dollar20Dispenser, Dollar10Dispenser
```
public class Dollar50Dispenser implements DispenseChain {
	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 50){
			int num = cur.getAmount()/50;
			int remainder = cur.getAmount() % 50;
			System.out.println("Dispensing "+num+" 50$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}
}
```

- Client
```
public class ATMDispenseChain {

	private DispenseChain c1;

	public ATMDispenseChain() {
		// initialize the chain
		this.c1 = new Dollar50Dispenser();
		DispenseChain c2 = new Dollar20Dispenser();
		DispenseChain c3 = new Dollar10Dispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}

	public static void main(String[] args) {
		ATMDispenseChain atmDispenser = new ATMDispenseChain();
		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				return;
			}
			// process the request
			atmDispenser.c1.dispense(new Currency(amount));
		}
	}
}
```

### 참고
- https://www.journaldev.com/1617/chain-of-responsibility-design-pattern-in-java
