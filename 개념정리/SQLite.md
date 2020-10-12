### SQLite

**데이터베이스에 데이터를 저장하는 작업은 반복적이거나 구조화된 데이터에 이상적이다.**

**android에서 데이터베이스를 사용할 때 필요한 API는 ```android.database.sqlite``` 패키지로 제공한다.**

--------

### 스키마 및 계약의 정의

* SQL  데이터베이스의 기본 원칙 중 하나는 스키마이다. 
  * 스키마: 데이터베이스의 구성 체계에 관한 공식적인 선언이다. 스키마는 데이터베이스를 생성할 때 사용하는 SQL 문에 반영된다. 체계적인 자체 문서화방식으로 스키마의 레이아웃을 명시적으로 지정하는 **계약 클래스**라고 하는 컴패니언 클래스를 생성하면 도움이 될 수 있다.
* 계약클래스는 URI, 테이블 및 열의 이름을 정의하는 상수를 유지하는 **컨테이너**이다. 계약 클래스를 통해 동일한 패키지의 다른 모든 클래스에 동일한 상수를 사용할 수 있다. 이렇게 하면 어느 한 곳에서 열 이름을 변경하고 이 변경사항을 코드 전체에 전파할 수 있다. 
* 계약클래스를 구성하는 좋은 방법은 클래스의 루트 수준에 있는 데이터베이스 전체에 전역적인 정의를 추가하는 것이다. 그런 다음 각 테이블의 내부 클래스를 생성한다. 각 내부 클래스는 상응하는 테이블의 열을 열거한다.

※ ```BaseColumns```인터페이스를 구현함으로써 내부클래스는 ```_ID```라고하는 기본 키 필드를 상속할 수 있다. ```CursorAdapter```와 같은 일부 android 클래스는 내부 클래스가 이러한 기본 키 필드를 가지고 있다. 기본 키 필드가 반으시가 필요한 것은 아니지만 데이터베이스가 android 프레임워크와 조화롭게 작동하는 데 도움이 될 수 있다.

* 예를 들어, 다음은 테이블 이름과 RSS 피드를 나타내는 단일 테이블의 열이름을 정의한다.

```java
public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}
```

-----------

### SQL Helper 사용하여 데이터베이스 생성

+ 데이터베이스의 모양을 정의한 후에는 데이터베이스 및 테이블을 생성 및 유지하는 메서드를 구현해야 한다. 다음은 테이블을 생성하고 삭제하는 일반적인 구문이다.

```java
private static final String SQL_CREATE_ENTRIES =
    "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
    FeedEntry._ID + " INTEGER PRIMARY KEY," +
    FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
    FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

private static final String SQL_DELETE_ENTRIES =
    "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
```

+ ```SQLiteOpenHelper```클래스에는 데이터베이스 관리를 위한 유용한 API세트가 포함되어 있다. 이 클래스를 사용하여 데이터베이스의 참조를 가져오면 시스템은 앱이 시작되고 있는 동안이 아닌 필요한 때에만 데이터베이스 생성 및 업데이트와 같이 장시간 실행될 수 있는 작업을 실행한다. 개발자는 ```getWritableDatabase()```또는```getReadableDatabase()```를 호출하면 된다.
+ ```SQLiteOpenHelper```를 사용하려면 ```onCreate()```및```onUpgrade()```콜백메서드를 재정의하는 서브클래스를 생성해야 한다. 또한 ```onDowngrade()```또는```onOpen()```메서드를 구현할 수도 있지만 이러한 메서드가 필수는 아니다.

