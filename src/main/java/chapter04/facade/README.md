## 퍼사드 (Facade)

### 목적
한 서브시스템 내의 인터페이스 집합에 대한 획일화된 하나의 인터페이스를 제공하는 패턴으로, 서브시스템을 사용하기 쉽도록 상위 수준의 인터페이스를 정의

### 동기
- 시스템을 서브시스템으로 구조화하면 복잡성을 줄이는 데에 도움이 되지만, 응용프로그램은 이런 구체적인 구현을 알 필요가 없다. 이를 위해 일반적인 기능에 대한 단순화된 하나의 인터페이스(상위 수준의 인터페이스)를 제공한다

### 활용
- 복잡한 서비스시템에 대한 단순한 인터페이스 제공이 필요할 때: 시스템의 범위가 확장되면 서브시스템은 계속 복잡해지며, 개발자가 복잡해진 각가의 클래스들을 다 이해하면서 시브시스템을 사용하기는 어렵다. 이 때 서브시스템에 대한 단순하면서도 기본적인 인터페이스를 제공한다
- 추상 개념에 대한 구현 클래스와 사용자 사이에 너무 많은 종속성이 존재할 때: 사용자가 서브시스템에 정의된 메서드를 직접 호출하지 않으므로 사용자와 서브시스템 간의 결합도를 줄일 수 있다
- 서브시스템을 계층화시킬 때, 각 서브시스템의 계층에 대한 접근점 제공: 서브시스템이 다른 서브시스템에 종속적이라 하더라도, 퍼사드를 통해서만 호출을 진행하게 함으로써 서브시스템 내부 설계 변경이 다른 서브시스템에 독립적으로 되어 서브시스템 간의 종속성을 줄일 수 있다

### 이점
- 서브시스템의 구성요소를 보호할 수 있다
- 서브시스템과 사용자 코드 간의 결합도를 더욱 약하게 만든다
- 응용프로그램이 서브시스템 클래스를 사용하는 것을 완전히 막지는 않는다: Facade를 사용할지 서브시스템 클래스를 직접 사용할지 결정할 수 있다

### 단점
- 서브시스템에 새로 추가되는 기능을 알 수 없다

### 구조
- Facade: 단순하고 일관된 통합 인터페이스를 제공한다. 서브시스템이 구성하는 어떤 클래스가 어떤 요청을 처리해야 하는지 알고 있고, 사용자의 요청을 해당 서브시스템 객체에 전달한다
- Subsystem classes: 서브시스템 기능을 구현하고, Facade 객체로 할당된 작업을 실제로 처리하지만 Facade에 대한 아무런 정보가 없다(즉, Facade에 대한 참조가를 갖지 않는다)

### 예제코드 (Ref. [Facade Pattern - Wiki](https://ko.wikipedia.org/wiki/%ED%8D%BC%EC%82%AC%EB%93%9C_%ED%8C%A8%ED%84%B4))
- Facade: Computer
```
class Computer {
   private CPU cpu;
   private Memory memory;
   private HardDrive hardDrive;
 
   public Computer() {
       this.cpu = new CPU();
       this.memory = new Memory();
       this.hardDrive = new HardDrive();
   }
 
   public void startComputer() {
       cpu.freeze();
       memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
       cpu.jump(BOOT_ADDRESS);
       cpu.execute();
   }
}
```

- Subsystem classes: CPU, Memory, HardDrive
```
class CPU {
   public void freeze() { // ... }
   public void jump(long position) { // ... }
   public void execute() { // ... }
}
```

### 참고
[Facade Pattern - Wiki](https://ko.wikipedia.org/wiki/%ED%8D%BC%EC%82%AC%EB%93%9C_%ED%8C%A8%ED%84%B4)
