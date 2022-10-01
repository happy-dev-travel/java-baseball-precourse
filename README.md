# 숫자 야구 게임
1-9까지의 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임
## 기능 요구 사항
### Model
* 중복이 없는 3개의 랜덤 숫자를 생성
* 같은 수가 있지만 다른 자리에 있으면 볼 판정
* 같은 수가 같은 자리에 있으면 스트라이크 판정
* 같은 수가 없으면 낫싱
### Controller
* 게임을 시작
* 사용자의 입력을 받아 Model의 판정을 View에 전달
* 사용자가 정답을 맞추면 초기 화면으로 이동
* 게임 종료 후 게임을 재시작
* 게임 종료 후 어플리케이션 종료
* 잘못된 값이 입력될 경우 IllegalArgumentException을 발생하고 종료
* (추가) 중간에 포기하고 싶을땐 esc key를 눌러 게임(한 판)을 종료하는 기능, 정답 공개 후 초기화면 출력
### View
* 초기 화면을 출력하는 기능
* 사용자 입력의 판정을 출력하는 기능
* 게임 종료 후 안내 출력(재시작 or 어플리케이션 종료)

## 예시
상대방(컴퓨터)가 425를 정했을 때
* 123을 제시 -> 1스트라이크
* 456을 제시 -> 1볼 1스트라이크
* 789를 제시 -> 낫싱

## 품질 요구 사항 (CleanCode)
* code Convention - https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java
* commit message convention -
* indent depth - Just 1
* no stream api
* no else claues
* 메소드는 10줄 이하(SRP 달성해야 함)
