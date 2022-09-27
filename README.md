# 숫자 야구 게임
1-9까지의 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임
## 기능 요구 사항
* 같은 수가 같은 자리에 있으면 스트라이크를 출력
* 같은 수가 있지만 다른 자리에 있으면 볼을 출력
* 같은 수가 없으면 낫싱을 출력
* 숫자를 맞출때 까지 반복할 수 있다.
* 게임(한 판)을 종료 후 다시 시작할 수 있다.
* 게임(한 판)을 종료 후 어플리케이션을 종료할 수 있다.
* 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 어플리케이션을 종료한다.
* 중간에 포기하고 싶을땐 esc key를 눌러 게임(한 판)을 종료할 수 있다. 상대방의 정답이 공개된다.

## 예시
상대방(컴퓨터)가 425를 정했을 때
* 123을 제시 -> 1스트라이크
* 456을 제시 -> 1볼 1스트라이크
* 789를 제시 -> 낫싱

## 품질 요구 사항 (CleanCode)
* code Convention - https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java
* indent depth - Just 1
* no stream api
* no else claues
* 메소드는 10줄 이하(SRP 달성해야 함)
