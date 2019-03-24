# chapter05. 행동 패턴 (Behavioral Patterns)

### 정의
- 클래스나 객체들이 상호작용하는 방법과 책임을 분산하는 방법을 정의: 어떤 처리의 책임을 어느 객체에게 할당하는 것이 좋은지, 알고리즘을 어느 객체에 정의하는 것이 좋은지 등 객체나 클래스 간의 교류 방법에 대하여 정의한다
  - 행동 클래스 패턴: 상속을 이용해서 알고리즘과 제어 흐름을 기술한다
  - 행동 객체 패턴: 하나의 작업을 수행하기 위해 객체 집합이 어떻게 협력하는지 기술한다. 하나의 객체가 스스로 모든 처리를 하는 것이 아니라, 관련된 객체들이 하나의 처리를 책임지는 방법이다(행동 처리의 책임을 분산)
  
### 행동 패턴 종류
- [책임 연쇄 (Chain of Responsibility)](https://github.com/Hyunhoo-Kwon/DesignPatterens/tree/master/src/main/java/chapter05/chain)
- [명령 (Command)](https://github.com/Hyunhoo-Kwon/DesignPatterens/tree/master/src/main/java/chapter05/command)
- 해석자 (Interpreter)
- 반복자 (Iterator)
