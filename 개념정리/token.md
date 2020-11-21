### Token

**사용자가 서비스에 액세스하도록 인증 받아야 한다. 애플리케이션도 사용자를 대신할 수 있는 권한을 부여받아야한다.**

아래 그림은 android 계정 관리자에게 유효한 인증 토큰을 가져오는 절차이다.

![인증 토큰 로직 다이어그램](https://developer.android.com/images/training/oauth_dance.png?hl=ko)

※ 토큰 작업을 실행하려면 다음 코드 스니펫과 같이 매니페스트 파일에 ```INTERNET```권한을 추가해야 한다.

```xml
<manifest ... >
        <uses-permission android:name="android.permission.INTERNET" />
        ...
    </manifest>
```

-----------

### 인증 토큰 요청하기

토큰을 가져오려면 ```AccountManager.getAuthToken()```을 호출한다.

```java
 AccountManager am = AccountManager.get(this);
    Bundle options = new Bundle();

    am.getAuthToken(
        myAccount_,                     // Account retrieved using getAccountsByType()
        "Manage your tasks",            // Auth scope
        options,                        // Authenticator-specific options
        this,                           // Your activity
        new OnTokenAcquired(),          // Callback called when a token is successfully acquired
        new Handler(new OnError()));    // Callback called if an error occurs
```

이 예에서 ```OnTokenAcquired```는 ```AccountManagerCallback```을 구현하는 클래스이다. 호출이 성공하면 토큰은 ``Bundle``내에 있다.

아래 코드는 ```Bundle```에서 토큰을 가져오는 방법이다.

```java
 private class OnTokenAcquired implements AccountManagerCallback<Bundle> {
        @Override
        public void run(AccountManagerFuture<Bundle> result) {
            // Get the result of the operation from the AccountManagerFuture.
            Bundle bundle = result.getResult();

            // The token is a named value in the bundle. The name of the value
            // is stored in the constant AccountManager.KEY_AUTHTOKEN.
            String token = bundle.getString(AccountManager.KEY_AUTHTOKEN);
            ...
        }
    }
```

```Bundle```의 ```KEY_AUTHTOKEN``` 키에 포함되어 있는 유효한 토큰을 사용할 수 있다. 

-----------

### 인증 토큰 다시 요청하기

첫 번째 인증 토큰 요청이 다음과 같은 이유로 실패할 수도 있다. 

+ 기기나 네트워크의 오류로 인해 ```AccountManager```가 실패한다.
+ 사용자가 앱에 계정 액세스 권한을 부여하지 않기로 했다.
+ 저장된 계정 사용자 인증 정보가 충분하지 않아 계정 액세스 권한을 얻지 못했다.
+ 캐시된 인증 토큰이 만료되었다.

-----------------

+ 제일 처음 두 사례의 경우 애플리케이션은 일반적으로 사용자에게 오류 메시지를 표시하기만 하는 방식으로 사소하게 처리할 수 있다. 네크워크가 다운되었거나 사용자가 액세스 권한을 부여하지 않기로 결정했을 때는
+ 애플리케이션이 할 수 있는 일이 별로 없다. 마지막 두 사례는 좀 더 복잡하다. 마지막 두 사례는 좀 더 복잡하다. 제대로 작동하는 애플리케이션은 이러한 실패를 자동으로 처리해야하기 때문이다.

+ 세 번째 실패 사례, 즉 불충분한 사용자 인증 정보는 `AccountManagerCallback`(이전 예에서 `OnTokenAcquired`)에서 수신한 `Bundle`을 통해 전달된다. `Bundle`의 `KEY_INTENT` 키에 `Intent`가 포함되어 있다면 인증자가 사용자와 직접 상호작용해야 유효한 토큰을 획득할 수 있다고 개발자에게 알려주는 것이다.
+ 인증자에서 `Intent`가 반환되는 데는 많은 이유가 있을 수 있다. 사용자가 이 계정에 처음으로 로그인했기 때문일 수도 있고 사용자의 계정이 만료되어 사용자가 다시 로그인해야 하거나 저장된 사용자 인증 정보가 잘못되었기 때문일 수도 있다. 계정에 2단계 인증이 요구되거나 망막 스캔을 위해 카메라를 활성화해야 하기 때문일 수도 있다. 그 이유가 무엇인지는 중요하지 않다. 유효한 토큰을 원한다면 `Intent`를 실행하여 가져와야 한다.



