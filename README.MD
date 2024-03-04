# 1일차
- 상속 관계 테이블인 경우 Inheritance 어노테이션을 붙여야 한다. strategy = InheritanceType으로 3가지가 있고 상황에 맞게 사용한다.
- 사용하는 곳에선 DiscriminatorColumn을 붙여서 구분할 칼럼을 넣어줘야한다.
- enum타입은 String을 사용하자. ordinal타입은 숫자로 들어가는데 중간에 값이 추가가 되면 숫자가 맞지 않는다.