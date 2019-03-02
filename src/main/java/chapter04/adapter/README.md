## 적응자 (Adapter or Wrapper)

### 의도
- 클래스의 인터페이스를 사용자가 기대하는 인터페이스 형태로 적응(변환)시킨다
- 서로 일치하지 않는 인터페이스를 갖는 클래스들을 함께 동작시킨다

### 동기
- 이미 개발된 클래스의 인터페이스를 수정할 수 없는 경우, 응용프로그램이 요청하는 인터페이스와 툴킷에 정의된 인터페이스에 둘 다 맞도록 적응자를 사용한다

### 활용
- 기존 클래스를 사용하고 싶은데 인터페이스가 맞지 않을 때
- 이미 만든 라이브러리를 재사용하고자 하나 이를 수정할 수 없을 때
- [객체 적응자만 해당] 이미 존재하는 여러 개의 서브클래스를 사용해야 할때 객체 적응자를 써서 부모 클래스의 인터페이스를 변형

### 구조
1. 클래스 적응자: 다중 상속을 활용해서 한 인터페이스를 다른 인터페이스로 적응시킨다
    - ex) SocketAdapter(Target)의 인터페이스와 Socket(Adaptee)의 구현을 모두 상속하여 SocketClassAdapterImpl(Adapter)를 구현
2. 객체 적응자: 객체 합성
    - ex) SocketAdapter(Target)의 인터페이스는 상속하며, Socket(Adaptee)의 인스턴스를 SocketClassAdapterImpl(Adapter)에 포함
  
### 구현 (Ref. [Adapter pattern](https://blog.seotory.com/post/2017/09/java-adapter-pattern))
##### 공통: target, adapter 
- Domain: Volt
```
public class Volt {
    private int volts;

    public Volt(int v) {
        this.volts = v;
    }
    ...
}
```

- Adaptee: Socket
```
public class Socket {
    public Volt getVolt() {
        return new Volt(120);
    }
}
```

- Target: SocketAdapter
```
public interface SocketAdapter {
    public Volt get120Volt();
    public Volt get12Volt();
    public Volt get3Volt();
}
```

##### 클래스 적응자 구현
- Adapter
```
public class SocketClassAdapterImpl extends Socket implements SocketAdapter {
    public Volt get120Volt() {
        return getVolt();
    }

    public Volt get12Volt() {
        Volt v = getVolt();
        return convertVolt(v, 10);
    }

    public Volt get3Volt() {
        Volt v = getVolt();
        return convertVolt(v, 40);
    }

    public Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }
}
```

##### 객제 적응자 구현
- Adapter
```
public class SocketObjectAdapterImpl implements SocketAdapter {

    private Socket sock = new Socket();

    public Volt get120Volt() {
        return sock.getVolt();
    }

    public Volt get12Volt() {
        Volt v = sock.getVolt();
        return convertVolt(v, 10);
    }

    public Volt get3Volt() {
        Volt v = sock.getVolt();
        return convertVolt(v, 40);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts()/i);
    }

}
```

### 참고
- [Adapter pattern](https://blog.seotory.com/post/2017/09/java-adapter-pattern)
