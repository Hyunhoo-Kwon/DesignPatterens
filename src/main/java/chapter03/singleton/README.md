## 단일체 (Singleton)

### 목적
오직 한개의 클래스 인스턴스만 갖도록 보장하고, 이에 대한 전역적인 접근점을 제공

### 동기
- 하나의 인스턴스만을 갖는 경우
  - 프린터 스풀
  - 다양한 리소스 pool (DB connection 등)
  - Configuration, Logger 등

### 활용
- 클래스의 인스턴스가 오직 하나여야 함을 보장하고, 잘 정의된 접근점으로 모든 사용자가 접근할 수 있도록 해야 할 때
- 유인한 인스턴스가 서브클래싱으로 확장되어야 하며, 사용자는 코드의 수정없이 확장된 서브클래스의 인스턴스를 사용할 수 있어야 할 때
  - ex) 싱글톤 클래스의 서브클래스 A, B의 총 인스턴스 개수 관리

### 이점
- Singleton 클래스 자체가 인스턴스를 캡슐화하기 때문에 인스턴스로의 접근을 통제/제어할 수 있다
- 전역 변수대신 단일체 패턴 사용 시 name space 관리 용이
- Singleton 클래스는 상속될 수 있기 때문에, 상속된 서브클래스를 통해서 새로운 인스턴스를 만들 수 있다 (연산 및 표현의 정제를 허용한다)
- 인스턴스 개수 변경 용이 (하나의 인스턴스로만 접근을 허용하는 방법이 아닌, 여러 개의 인스턴스를 생성해서 접근하도록 변경 가능)

### 단점
- 싱글톤 클래스가 많은 의존성을 가지게 되면 객체들 간의 결합도 증가
- 멀티 스레드 환경에서 인스턴스 초기화 주의점
  - 아직 초기화 되지 않은 싱글톤 클래스를 여러 스레드에서 동시에 호출 시 의도하지 않게 여러 개의 인스턴스 생성 가능

### 예제코드
1. 일반적인 방법: 인스턴스를 변수로 저장하고 클래스 연산(정적 멤버 함수)으로 변수를 되돌려 줌 [[예제코드]](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter03/singleton/LazySingleton.java)
    - 아직 초기화 되지 않은 싱글톤 클래스를 여러 스레드에서 동시에 호출 시 의도하지 않게 여러 개의 인스턴스 생성 가능
```
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```

2. static 초기화 방법: Class가 로딩되는 시점, 즉 static 영역의 데이터 로딩 시점에 인스턴스 초기화 [[예제코드]](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter03/singleton/EagerSingleton.java)
    - 싱글톤 클래스를 한번도 호출 안하더라도 인스턴스를 미리 만들어 놓기 때문에 메모리 낭비가 있을 수 있다
```
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton(); // static 초기화시 바로 할당
    
    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
```

3. lazyHolder 방법: Class 로딩을 이용한 방법. instance 호출 시 초기화가 진행된다
    - singleton 클래스에 LazyHolder 변수가 없기 때문에 singleton 클래스 로딩 시 LazyHolder 클래스를 초기화 하지 않는다. getInstance() 에서 LazyHolder.INSTANCE를 참조하는 순간 Class가 로딩되며 초기화가 진행된다.
    - Class를 로딩하는 시점은 thread-safe를 보장한다
```
public class LazyHolderSingleton {

    private LazyHolderSingleton() {
    }

    public static LazyHolderSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LazyHolderSingleton INSTANCE = new LazyHolderSingleton();
    }
}
```

### 참고
- [[JAVA 디자인패턴] Singleton 패턴의 모든 것 (멀티스레드 고려)](https://javaplant.tistory.com/21)
- [Singleton pattern pros and cons](https://medium.freecodecamp.org/singleton-design-pattern-pros-and-cons-e10f98e23d63)
- [Singleton in ES6](https://medium.com/@dmnsgn/singleton-pattern-in-es6-d2d021d150ae)
