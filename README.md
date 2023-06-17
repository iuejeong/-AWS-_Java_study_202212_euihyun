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
