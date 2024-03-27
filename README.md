![notion용3](https://github.com/sonincheon/Doggo-frontend/assets/142462485/5a439b87-be96-4fa8-966b-2ddca0c18a91)
## 손인천 담당 기능 요약 ##

1. ML을 이용한 기대 수명 예측(파이썬)
  - 데이터셋은 Kaggle의 2015년 전세계 국가별 평균 수명 자료로 판다스로
    데이터를 가지고와필요한 데이터만 따로 꺼내와 사용하되 결측치를
    중간값으로 임의 설정 및 정제하여 사용하고 타겟은 평균수명으로 두어
    특성을 나누었습니다. 
  - 머신러닝의 모델로서는 비선형구조라 판단하에 파이썬 라이브러중
    사이킷런의 랜덤포레스트를 채택해서 사용, 정제해둔 데이터로 훈련시켜
    오차범위가 2.7% 로 확인 완료하여 머신러닝 모델화 구현
  - Axios의 요청값을 Spring을 걸쳐 Flask로 전달, 전달된 데이터 기반으로
    모델링된 머신러닝이 기대 수명 예측 값 도출하여 반환 구현
  - 내 블로그 (머신러닝) : https://cheonsdev.tistory.com/13
    
2. 웹소켓을 이용한 실시간 채팅 및 친구 관리 기능
  - 채팅룸 id를 회원별 id + 회원별 id로 정의하여 사용하여 1:1 채팅 구현 
  - 생성된 세션의 채팅룸id 및 대화내용을 DB에 따로 저장하여 세션의 삭제
    이후에 생성이되어도 같은 내용이 나올수있게 출력 구현
  - 메세지에 읽음, 안읽음 과 현시간을 넣어주어 실시간임을 부각시켜줌
    읽음과 안읽음은 상대회원이 참여,미참여,참여후로 나누어 변경도록진행
  - 나에게 채팅이 오는것을 확인할수있게 채팅방에 안읽은 메세지가 나오게
    하는 count를 설정하여 useEffect에 인터벌을 넣어 초단위로 나에게 연
    락한 채팅수 확인 구현 
  - 친구관리는 랭킹페이지 / 커뮤니티페이지에서의 유저이름을 클릭시,
    open되는 모달로 친구 추가 및 1:1대화로 연결 구현 친구리스트를 출력

3. 이외의 활동
   - Spring의 JWT 보안토큰 관련 에러 수정 및 피드백
   - Axios 인스턴스 생성하여 401에러시, JWT토큰 재발급
  
## 정벼리 담당 기능 요약 ##

1. ELK 를 활용한 건강기능식품 조회 
 - 건강기능식품정보포털(https://www.hffinfo.com/search/product)를 
    개발자 도구로 분석하여 네트워크항목의 fetch/xhr의 API 송수신 기록을 
    확인하여 해당 어플리케이션에  JWT와 같은 보안처리가 전무함을 확인하여
    해당서버에 등록된 모든 건강기능정보식품을 가져옴
 - Kibana 콘솔에서 한글 형태소 분석기인 nori를 적용하여 특수문자나 
   "은는이가, 하지만" 등 필요없는 문자들을 누락처리하게함
 - Spring Boot의 Elasticsearch api를 활용하여 query 정보에 필터조건을 
   부여하는 boolQueryBuilder와 페이지,사이즈,정렬들을 조절할 수 있는 
   nativeSearchQueryBuilder를 사용하여 페이지네이션 및 정렬 구현
 - React에서 각종 필터(드롭다운,콤보박스, 사이즈)를 설정할 수 있는 컴포넌트 
   구현
 - react-table라이브러를 통해 도큐먼트의 각 필드에 해당하는 정보들이 
   컬럼에 맞춰서 렌더링되게 구현
 - 페이지네이션의 경우 10단위로 그룹을 지어, "<", ">" 버튼을 클릭시에 11 
   혹은 21와 같은 페이지에 이르렀을때 "X1" ~ "X0" 형식으로 선택할 수 있게함
 - 사용자가 새로고침을 하더라도 검색결과를 보여주고 있는 페이지가 여전히 
   렌더링 되게 URLsearchParams(쿼리스트링)을 사용하여 편의성 증대
 - 모바일 화면의 경우 중요도가 떨어지는 필드(신고번호, 국내/해외)의 컬럼과 
   로우를 생략함과 동시에, 텍스트정보가 영역을 넘은경우 "..." 처리 및 터치시 
   해당 영역이 확장되게함

2. 식단정보&운동수행정보 관리 캘린더
 - 사용자는 날짜마다 섭취한 음식과 수행정보를 기입하게 되고 이에 맞춰 
  캘린더 테이블에 레코드가 생성이 되는데 로직을 순서에 맞춰 설명을 하게되면 
  
  (1)식단정보 혹은 운동정보를 INSERT-> (2)식단정보 혹은 운동정보 DTO에서 
  사용자의 이메일정보를 획득 및 검증 ->(3) 해당 DTO에서 사용자가 입력한 
  운동정보 혹은 식단정보를 획득 및 검증 -> (4)해당 DTO에서 운동 정보 혹은 
  식단정보를 입력한 날짜정보를 획득 및 검증 -> (5) 식단정보 및 운동정보 
  기입시 25점씩 할당 및 검증(하루최대 100점) -> (6)사용자의 토탈랭킹 
  정보를 조회 및 검증후 점수 UPDATE -> (7)사용자의 시즌랭킹 정보를 조회 및 
  검증 후 점수 UPDATE -> (7)트랜잭션에 의해 앞선 조건이 실패시 무효화 -> 
  (8)해당 로직을 반복하여 종합된 정보를 캘린더테이블에 INSERT 혹은 
  UPDATE

 - 리액트의 react-calendar 라이브러리를 통해 날짜정보를 제공받고 
   로컬스토리지를 통해 제공되는 사용자의 Email정보를 API를 통해 파라미터로 
   요청하여 월별 일별 정보들 list<dto>형태로 return 받음
  
 - list<dto>에 날짜정보가 담긴 객체리터럴의 정보를 react-calendar에서 
   return 하는 날짜정보와 매핑하여 날짜별로 렌더링
 - 월별정보에서는 "아침", "점심", "저녁", "운동" 기록 여부를 "✅" or "❌" 로  
   표시
- 캘린더에서 각 날짜를 클릭하면 등장하는 모달은 일별정보를 표현하고 있는데
   ApexCharts 라이브러리를 통해 구현된 시각화 표현을 통해 선택한 날짜 +- 
   3일에 해당하는 섭취칼로리와 수평선(권장칼로리)을 통해 초과or미만 유무를 
   확인할 수 있음
- 시각화 그래프 하단에는 섭취한 "탄수화물", "단백질", "지방" 을 그램 단위로 
   확인할 수 있고 "탄수화물"은 밥공기, "단백질",은 고기, "지방"은 돼지 
   이모티콘등을 사용하여 시인성을 강화하였음
- 해당 정보들 하단에 "기록하기", "닫기" 버튼을 통해 닫거나 기록 선택
- "기록하기" 선택시 모달의 내용이 "아침", "점심", "저녁", "운동" 으로 전환
   클릭시 input창 생성 및 텍스트를 입력하여 알맞는 음식정보와 운동정보를 
   검색및 기록할 수 있음

3. 시즌&통합 랭킹
 - 캘린더 레코드 생성 로직중 식단정보와 운동정보를 insert시에 25점씩 
   할당하게 되는데, insert 시 유무를 true or false 분류하여 하루에 최대 
   100점 획득 로직을 거쳐 토탈랭킹에 레코드를 생성하거나 업데이트
 - 토탈랭킹의 레코드내 날짜정보를 바탕으로 시즌랭킹의 레코드도 생성이 
   되는데 년월정보를 파라미터로 사용하여 한달단위로 레코드 생성과 업데이트 
   주기를 정함
 - React에서 시즌/남자/여자/통합 등의 카테고리버튼 컴포넌트를 구현하여 각 
   버튼을 클릭할시 항목별로 렌더링
  - 건강기능식품 페이지의 react-table을 재활용하여 페이지네이션을 구현

4. 이외의 활동
 - GitHUB의 모든오류 사항들을 관리하였음
 - 협업과 유지보수를 위하여 코딩 가이드(프론트) 정의(ex: Presentational & 
   Container 패턴, 공용 레이터 컴포넌트, 커스텀 훅, Context + Reducer, 
   프로젝트 구조 등) 
 - 협업과 유지보수를 위하여 코딩 가이드(백엔드) 정의(ex: JsonNaiming 
   어노테이션 사용을 위한 표기법 통일, 빌더 패턴, CRUD 인터페이스 클래스, 
   추상클래스, 스웨거 환경설정)
   
   ## 확인사항
   
 - WellV 프론트엔드 
    (https://github.com/VerifiedIdiot/HealthyLife_Frontend)
 - WellV 백엔드 (https://github.com/VerifiedIdiot/HealthyLife_Backend)
 
인사담당관님의 피드백을 환영합니다!