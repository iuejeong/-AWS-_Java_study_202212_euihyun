## 📌 출력
<details>
<summary>HelloJava.java</summary> 
<div markdown="1">       
  
```java
  
  public class HelloJava {
  
    	public static void main(String[] args) {
		System.out.println("Hello, Java!!");
		System.out.println("이름: 정의현");
		System.out.println("주소: 부산 사하구 괴정동");
		System.out.println("연락처: 010-5834-3585");
		System.out.println("수업: AWS기반 공공빅데이터 활용 웹개발자 양성");
	  }
  
  }
  
```
  
#### 출력물
  
```
Hello, Java!!
이름: 정의현
주소: 부산 사하구 괴정동
연락처: 010-5834-3585
수업: AWS기반 공공빅데이터 활용 웹개발자 양성
  
```
  
---
  
- System.out.println은 "한 줄의 문자열을 출력 후 끝에 줄바꿈을 해라"라는 의미를 갖고 있다.

---
  
</div>
</details>

<details>
<summary>Output1.java</summary> 
<div markdown="1">       
  
```java
  
public class Output1 {

	public static void main(String[] args) {
		System.out.print("이름: ");
		System.out.println("정의현");
		System.out.print("나이: ");
		System.out.println("29" + "1");
		System.out.println("이름: " + "정의현");
	}

}
  
```
  
#### 출력물
  
```
  
이름: 정의현
나이: 291
이름: 정의현
  
```
  
--- 
 
- 이때 알아야 할 것은 나이의 결과가 291이 나왔는데, 이는 "29"와 "1"이 합쳐진 "문자열"이다.

---
  
</div>
</details>

<details>
<summary>Output2.java</summary> 
<div markdown="1">       
  
```java
  
public class Output2 {

	public static void main(String[] args) {
		int year = 5;
		
		System.out.println("이름: 김준일");
		System.out.println("나이: " + (20 + year));
		System.out.println("이름: 김준이");
		System.out.println("나이: " + (21 + year));
		System.out.println("이름: 김준삼");
		System.out.println("나이: " + (22 + year));
		System.out.println("이름: 김준사");
		System.out.println("나이: " + (23 + year));
	}

}
  
```
  
#### 출력물
  
```
  
이름: 김준일
나이: 25
이름: 김준이
나이: 26
이름: 김준삼
나이: 27
이름: 김준사
나이: 28
  
```
  
---
  
- 자료형 int와 변수명 year을 선언해준 후 값을 5로 넣는다.

- int는 정수를 뜻하기 때문에 값은 정수만 들어가고 출력된다는 것을 명심

---
  
</div>
</details>


## 📌 변수
<details>
<summary>Variable1.java</summary> 
<div markdown="1">       
  
```java
  
public class Variable1 {

	public static void main(String[] args) {

		int num = 0;
		int num2;
		num2 = 10;
		System.out.println(num + num2);
		
	}

}
  
```
  
#### 출력물
  
```
  
10
  
```
  
---
  
- 선언과 초기화를 동시에 명시

- 4byte의 메모리 공간을 할당할 것이고 그 공간의 이름을 num2라 하겠다!선언
  
- num2변수명을 가진 메모리 공간의 데이터릍 비우고 10의 값을 대입하겠다. 초기화

---  

</div>
</details>

<details>
<summary>Variable2.java</summary> 
<div markdown="1">       
  
```java
  
public class Variable2 {

	public static void main(String[] args) {
		char firstName1 = '준';
		char firstName2 = '일';
		
		char alphabetA = 'A';
				
		System.out.println("김"+ firstName1 + firstName2);
		System.out.println("알파벳A: " + alphabetA);
		
		System.out.println(alphabetA + 'B');
		System.out.println('0');
		System.out.println(firstName1 + 0);
	
	}


}
  
```
  
#### 출력물
  
```
  
김준일
알파벳A: A
131
0
51456
  
```
  
--- 
 
- 자료형에는 기본 자료형과 참조 자료형이 있다.

- 기본자료형의 종류에는 
  byte, char, int, long
  float, double이 있다.
  
- byte ~ long까지를 정수로 출력을 하고,
  float과 double은 실수로 출력
  
- char이라는 자료형은 character라고 읽는다.

  다른 자료형과는 다르게 char는 문자열이 아니라 '문자'가 출력이 된다.
  
---

</div>
</details>

<details>
<summary>Variable3.java</summary> 
<div markdown="1">       
  
```java
  
public class Variable3 {

	public static void main(String[] args) {
		final int NOW_AGE = 5;
		System.out.println(NOW_AGE);
	}


}
  
```
  
#### 출력물
  
```
  
5
  
```
  
---
  
- 상수: 자료형 앞에 final이 붙는다.

- 상수는 상수명을 무조건 대문자로 사용을 한다.

---

</div>
</details>

## 📌 형변환

<details>
<summary>Casting1.java</summary> 
<div markdown="1">       
  
```java
  
public class Casting1 {

	public static void main(String[] args) {
		char a = 'a';
		int num1 = a;
		
		System.out.println((double) a);
		System.out.println((char) 97);
		System.out.println((byte) 300);
	}

}
  
```
  
#### 출력물
  
```
  
97.0
a
44
  
```
  
---
  
- 기본 타입의 크기 순으로는
  
  정수 : byte(2byte), char(2byte), int(4byte), long(8byte)

  실수 : float(4byte), double(8byte)

- 기본 타입의 default는 정수 : int, 실수 : double이다.

---

</div>
</details>

<details>
<summary>Casting2.java</summary> 
<div markdown="1">       
  
```java
  
public class Casting2 {

	public static void main(String[] args) {
		char char_a = 'a';
		int num = (int) char_a;
		
		char char_b = (char) (num + 1);
		
		System.out.println(char_b);
		
	}

}
  
```
  
#### 출력물
  
```
  
b
  
```
  
---
  
- 업캐스팅: 상위로 올라간다 (자동)

- 다운캐스팅: 하위로 내려간다 (수동)

---

</div>
</details>

## 📌 연산자

<details>
<summary>Operation1.java</summary> 
<div markdown="1">       
  
```java
  
public class Operation1 {

	public static void main(String[] args) {
		int add = 1 + 2;
		int sub = 10 - 5;
		int mul = 10 * 2;
		int div = 10 / 4;
		int remainder = 10 % 5;
		
		
		System.out.println(add);
		System.out.println(sub);
		System.out.println(mul);
		System.out.println(div);
		System.out.println(remainder);
		
		System.out.println(remainder == 0 ? "5의 배수이다" : "5의 배수가 아니다");
		
	}

}
  
```
  
#### 출력물
  
```
  
3
5
20
2
0
5의 배수이다
  
```
  
---
  
- 단항 연산자 : 항이 하나
	
  ex) ++num, --num -> 증감 연산자

- 이항 연산자 : 항이 두 개
	
  ex) +,-

- 삼항 연산자 : 항이 세 개
	
  ex) ?
	
- 대입 연산자 : 변수에 값을 대입하는 연산자
	
  ex) =
	
- 산술 연산자 : +,-,*,/,%
	
  "+" : 더한다

  "-" : 뺀다

  "*" : 곱한다

  "/" : 나눈다

  "%" : 나누어서 나머지를 구한다
	
---

</div>
</details>

<details>
<summary>Operation2.java</summary> 
<div markdown="1">       
  
```java
  
public class Operation2 {

	public static void main(String[] args) {
		int num = 10;
		
		num = num + 1;
		
		System.out.println(num++);
		System.out.println(num++);
		System.out.println(num);
		
	}

}
  
```
  
#### 출력물
  
```
  
11
12
13
  
```
  
---
  
- 증감 연산자 : ++,--

  ++ : 1을 더한다

  -- : 1을 뺀다

ex) ++num -> 선증가

   num++ -> 후증가
	
---

</div>
</details>

<details>
<summary>Operation3.java</summary> 
<div markdown="1">       
  
```java
  
public class Operation3 {

	public static void main(String[] args) {
		int num = 10;
		
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = num % 2 > 0;
		
		System.out.println(flag1 && flag2);
		System.out.println(flag1 && flag3);
		System.out.println(!(flag2 || flag3 && flag1));
		
	}

}
  
```
  
#### 출력물
  
```
  
true
false
false
  
```
  
---
  
- 관계 연산자 : >, <, >=, <=, ==, !=

- 논리 연산자 : 0외에는 참이다
			
AND(곱) : &&, 모든 조건이 부합해야 함

OR(합) : ||, 하나만 참이어도 참

NOT(부정) : !
			
- 조건 연산자 : 조건식 ? 결과1 : 결과 2

조건식이 참이면 결과1을 반환, 거짓이면 결과2를 반환

결과1,2는 자료형이 같아야 한다

조건문이 길어질 경우 연산자 앞에서 끊어줌

삼항 연산자의 경우 :에서 끊어줌
	
---

</div>
</details>
	
<details>
<summary>Operation6.java (시험 성적을 학점으로 계산하는 프로그램)</summary> 
<div markdown="1">       


 * 정수자료형 score변수 선언
 * 88점으로 초기화
 * 
 * 문자자료형 grade변수 선언
 * 
 * 조건
 * score가 0점보다 작거나 100점보다 크면 X를 출력
 * score가 90 ~ 100점이면 A학점
 * score가 80 ~ 89점이면 B학점
 * score가 70 ~ 79점이면 C학점
 * score가 60 ~ 69점이면 D학점
 * score가 50 ~ 59점이면 F학점
	
```java
  
public class Operation6 {

	public static void main(String[] args) {
		int score = 40;

		char grade = 0 > score || score > 100 ? 'X' 
				: score > 89 ? 'A' 
				: score > 79 ? 'B'
				: score > 69 ? 'C'
				: score > 59 ? 'D' : 'F'; 

		char plus = score > 100 || score < 60 ? '\0' : score % 10 > 4 || score == 100 ? '+' : '\0';

		System.out.println("점수" + "(" + score + "): " + grade + plus + "학점");
		
	}

}
  
```
  
#### 출력물
  
```
  
점수(40): F
  
```
  
---
  
- score에 내가 입력하고 싶은 점수를 입력
	
- 입력한 점수를 조건애 맞게 학점이 출력이 된다.
	
- plus는 예를 들어 A0나 A+를 출력할 수 있게 삼항연산자로 조건을 걸어준다.
	
---

</div>
</details>
	
## 📌 입력(Scanner)
	
<details>
<summary>input1.java</summary> 
<div markdown="1">       
	
```java
  
public class input1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int num5 = 0;
		
		System.out.print("입력1: ");
		 num1 = scanner.nextInt();
		System.out.print("입력2: ");
		 num2 = scanner.nextInt();
		System.out.print("입력3: ");
		 num3 = scanner.nextInt();
		System.out.print("입력4: ");
		 num4 = scanner.nextInt();
		System.out.print("입력5: ");
		 num5 = scanner.nextInt();
		
		
		System.out.println("입력값: " + (num1 + num2 + num3 + num4 + num5));
	}

}
  
```
  
#### 출력물
  
```
  
입력1: 1
입력2: 2
입력3: 3
입력4: 4
입력5: 5
입력값: 15
  
```
  
---
  
- 문자열은 뭘 합쳐도 문자열이 됨
	
- 초기 변수 선언할 때 int num = 0;처럼 초기화를 해주는 게 좋다
	
- System : 운영체제라고 생각하면 됨
	
---

</div>
</details>
	
<details>
<summary>input2.java</summary> 
<div markdown="1">       
	
```java
  
public class input2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("문자열1: ");
		String str1 = scanner.nextLine(); // 띄어쓰기 허용
		
		System.out.print("문자열2: ");
		String str2 = scanner.next(); // 띄어쓰기 와 엔터가 동일하게 생각함. 그래서 띄어쓰기 허용 불가
		
		System.out.println("정수: ");
		int number1 = scanner.nextInt();
		
		System.out.println("실수: ");
		double number2 = scanner.nextDouble();
		
		System.out.println("사용자 문자열1: " + str1);
		System.out.println("문자열2: " + str2);
		System.out.println("정수: " + number1);
		System.out.println("실수: " + number2);
		
	}

}
  
```
  
#### 출력물
  
```
  
문자열1: 가 나 다
문자열2: 라
정수: 
1
실수: 
1.0
사용자 문자열1: 가 나 다
문자열2: 라
정수: 1
실수: 1.0
  
```
  
---
	
- next(); : 띄어쓰기 허용 불가 (띄어쓰기 와 엔터가 동일하게 생각함)
	
- nextLine(); : 띄어쓰기 허용
	
---
	
next()에서 띄어쓰기를 쓸 경우 다음과 같이 내가 엔터로 내가 직접 입력하지 않아도 값이 들어간 걸 확인할 수 있다.
	
#### 출력물
	
```

문자열1: 가
문자열2: 가 1 1.0
정수: 
실수: 
사용자 문자열1: 가
문자열2: 가
정수: 1
실수: 1.0
	
```

</div>
</details>
	
<details>
<summary>input3.java</summary> 
<div markdown="1">       
	
```java
  
public class input3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String name = null;
		int age = 0;
		String address = null;
		String phone = null;
		
		
		System.out.print("이름: ");
		name = scanner.next();
		
		System.out.print("나이: ");
		age = scanner.nextInt();
		
		scanner.nextLine();
		
		System.out.print("주소: ");
		address = scanner.nextLine();
		
		System.out.print("연락처: ");
		phone = scanner.next();
		
		System.out.println("사용자의 이름은 " + name + "이고 나이는 " + age + "살입니다.");
		System.out.println("주소는 " + address + "에 거주 중입니다.");
		System.out.println("연락처는 " + phone + "입니다.");
		
	}

}
  
```
  
#### 출력물
  
```
  
이름: 정의현
나이: 24
주소: 부산광역시 사하구 괴정동
연락처: 010-5834-3585
사용자의 이름은 정의현이고 나이는 24살입니다.
주소는 부산광역시 사하구 괴정동에 거주 중입니다.
연락처는 010-5834-3585입니다.
  
```
  
---
  
- scanner.next()는 공백이나 개행 문자를 기준으로 문자열을 구분한다.
	
- scanner.nextInt()는 정수 값을 읽어들어온다.

  이 때, scanner.nextInt()는 정수 값을 읽은 후에 개행 문자를 버리지 않고 그대로 둔다.
	
- scanner.next()로 이름을 입력받은 후에 scanner.nextLine()을 호출하는 이유는 개행 문자를 제거하기 위해서다. 

  개행 문자가 제거되지 않으면 주소 입력부분에서 scanner.nextLine()은 개행 문자를 읽어오기만 하고 실제 주소를 입력받지 않게 된다.
	
- 그래서 위 코드에서는 scanner.nextLine()은 개행 문자를 처리하기 위한 용도로 중간에 사용했다.
	
---
	
scanner.nextLine()을 중간에 사용하지 않고 그대로 쓴다면?

#### 출력물
	
```

이름: 정의현
나이: 24
주소: 연락처: 010-5834-3585
사용자의 이름은 정의현이고 나이는 24살입니다.
주소는 에 거주 중입니다.
연락처는 010-5834-3585입니다.
	
```
	
이처럼 개행 문자를 처리하지 못한 상태에서 주소는 건너뛰고 바로 연락처로 넘어가지는 모습을 볼 수 있다.

</div>
</details>
	

