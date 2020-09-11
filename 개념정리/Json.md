### JSON 구조

+ json 데이터는 이름과 값의 쌍으로 이루어진다.
+ json 데이터는 쉼표로 나열된다.
+ 객체(object)는 중괄호{}로 둘러쌓아 표현한다.
+ 배열(array)는 대괄호[]로 둘러쌓아 표현한다.

--------

### JSON 데이터

 json 데이터는 데이터 이름, 콜론(:), 값의 순서로 구성된다.

```"데이터이름":값```

ex) ```"name":"식빵"```

데이터의 이름도 문자열이므로, 항상 큰따음표("")와 함께 입력한다.

데이터의 값으로는 다음과 같은 타입이 올 수 있다.

1. 숫자
2. 문자열
3. 불리언
4. 객체
5. 배열
6. NULL

----------

### JSON 객체

json 객체는 중괄호{}에 둘러쌓아 표현한다.

json객체는 쉼표(,)를 사용하여 여러 프로퍼티를 포함할 수 있다.

```json
{
	"name":"식빵",
	"family":"웰시코기",
	"age":1,
	"weight":2.14
}
```

json 객체를 그림으로 나타낸 것

![img](http://tcpschool.com/lectures/img_json_object.png)

-----------

### JSON 배열

json 배열은 대괄호[]로 둘러쌓아 표현한다.

json 배열은 쉼표를 사용하여 여러 json 데이터를 포함할 수 있다.

```json
"dog":{
{"name":"식빵", "family":"웰시코기", "age":1, "weight":2.14},
{"name": "콩콩", "family": "포메라니안", "age": 3, "weight": 2.5},
{"name": "젤리", "family": "푸들", "age": 7, "weight": 3.1}
}
```

json 배열을 그림으로 나타낸 것

![img](http://tcpschool.com/lectures/img_json_array.png)