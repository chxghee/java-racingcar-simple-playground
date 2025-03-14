# 🏎️ 자동차 경주
> 주어진 횟수 동안 레이싱에 참여하는 자동차를 움직이고 우승자를 가려내는 게임

## 1단계 - 움직이는 자동차

### 📝 기능 요구사항 
 ✅ 자동차는 이름을 가지고 있다.
 
 ✅ 자동차는 움직일 수 있다.
 
   ☑️ 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.

### 💻 구현 전략
1. Car 객체에 이름과 현재위치를 저장할 필드 추가
2. 랜덤값이 주어지면 해당 값에 전진할지 말지를 결정하여 현재 위치를 조정할 메서드


<br>

---

## 2단계 - 우승 자동차 구하기

### 📝 기능 요구사항 

 ✅ n대의 자동차가 참여할 수 있다.
 
 ✅ 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 
   ☑️ 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
   
 ✅ 자동차 경주 게임을 완료한 후 누가 우승했는지를 구할 수 있다. 우승자는 한 명 이상일 수 있다.


### 💻 구현 전략
1. Racing 객체에 레이싱에 참여하는 자동차들을 리스트로 저장할 필드 추가
2. 주어진 n값 만큼 자동차를 생성하여 리스트에 저장
3. 모든 자동차 각각에 대해 랜덤값을 할당하고 자동차를 이동시킬 메서드
4. 주어진 횟수만큼 각 라운드를 진행할 메서드
5. 우승자를 가려내는 메서드
