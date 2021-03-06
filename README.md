
# 프로젝트 소개

스레드를 활용한 벽돌 깨기 게임

게임을 시작하면 공이 날아가게 되면서 블럭을 맞추는 게임이다. 스테이지는 3개로 나뉘어져 있고 공이 다 떨어지면 게임 오버, 블럭을 다 맞추게 되면 게임 클리어를 한다.

## 기능

- 시작화면, 게임시작
- 스테이지 3개 중 하나 선택
- 공속도 랜덤, 블럭 생성
- 화살표(좌,우)나 a,d키를 누르면 바가 이동
- 바가 창밖으로 나가지 않도록 설정
- 블럭의 색깔에 따라 점수 차별화
- 게임 끝나면 게임 종료, 스테이지 다시선택하기
- 회원가입, 로그인 구현


## 시연영상


<div>
	<a href="https://www.youtube.com/watch?v=4FKeZpDfrCs" target="_blank"><image src = "https://img.youtube.com/vi/4FKeZpDfrCs/mqdefault.jpg"></a>	

</div>
	
	
	
	

## 개발 환경

개발 버전 : JDK 11.0.10 </br>
플러그인 : mariadb-java-client-2.5.4 </br>
개발 프로그램 : JDE: Eclipse

## 잘한 점

- 멀티스레드 활용과 JFrame 활용을 생각보다 잘한 것 같다.
- 기능을 사용하기 위해서 스레드 및 생성자 공부를 했다.
- 설계는 벽돌깨기 게임 스테이지 3개를 구현을 했다.


## 어려웠던 점들

- static을 쓰지 않으면 버그가 일어났고, static 없이 실행시키려고 코드를 수정해 봤지만 실행이 안됐다.
- 블럭과, 볼의 스레드를 추가하는 과정에서 모르는 버그들이 많이 일어나서 스레드 내의 조건을 수정하거나 프레임 에서의 타이머와 볼,블럭 스레드를 수정하는 등의 공부를 해야되겠다.
- 스테이지 1,2,3 코드를 다 짰지만 중복되는 코드가 많아 중복되는 코드를 일관성 있게 수정할려고 했지만 여러 오류들이 일어나서 그대로 냅뒀다.


## 개선해야될 점들

- DB를 활용해서 회원가입 및 로그인 구현까지는 했으나 점수 및 랭킹을 출력할 수 있도록 할 것이다.
- 공과 블럭이 충돌할 시 공이 일직선으로 나가는 버그가 있어 점차 수정해 나갈 것이다.
- 배경 음악과 효과음을 추가할 것이다.
- 블럭을 여러번 맞춰야 없어지는 블럭을 만들것이다.


## SQL문
```mysql
create table member(
email VARCHAR(40) UNIQUE NOT NULL, -- 40글자수 제한, 중복 제한
password VARCHAR(15) NOT NULL,   -- 15글자 제한, 특수문자, 숫자, 영문 포함,
nickname VARCHAR(20) UNIQUE NOT NULL,  -- 20글자 제한, 중복 제한
stage INT DEFAULT 1,		-- 3개의 스테이지, 기본 1
score INT DEFAULT 0		-- 점수, 기본 0
)
```	
	
	
[Javadoc](https://pkkj12.github.io/mini_project/mini_project/doc/index.html)
	
	

	
	

