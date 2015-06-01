# 기술적인 특장점


## 서버와 클라이언트의 코드 활용

### Response.class를 통해 컨트롤러의 return type을 정형화

Response : 응답 데이터의 상태를 알 수 있는 code와 message를 담고 있음
서버 측에서는 모든 컨트롤러의 return type이 같아 가독성이 높고 로직이 정형화 됨
클라이언트는 응답 데이터의 상태를 바로 알 수 있고, 따로 message parsing이 필요 없음

###[Server](https://github.com/NHNNEXT/2015-01-HUDIWEB-USS/blob/master/src/uss/response/Response.java)

    public class Response {
        public final static int ERROR = 0;
    	public final static int ERROR_USER_ALERT = 1;
    	public final static int SUCCESS = 2;
    	public final static int SUCCESS_USER_ALERT = 3;
    	public static final Integer ERROR_SESSION_REQUIRE = 4;
        
    }

###[Client](https://github.com/NHNNEXT/2015-01-HUDIWEB-USS/blob/master/webapp/js/myprofile.js)

    var reponseType = {
                ERROR: 0,
                ERROR_USER_ALERT: 1,
                SUCCESS: 2,
                SUCCESS_USER_ALERT: 3,
                SUCCESS_SESSION_NULL: 4
            };
    
            var success = http.success;
            http.onResponse = function (call) {
                success(function (response) {
                    switch (response.code) {
                        case reponseType.ERROR:
                            return;
                        case reponseType.ERROR_USER_ALERT:
                            alert(response.message);
                            return;
                        case reponseType.SUCCESS:
                            break;
                        case reponseType.SUCCESS_USER_ALERT:
                            alert(response.message);
                            break;
                        case reponseType.SUCCESS_SESSION_NULL:
                            alert("Login Session Not Exist or Expired, Please Login");
                            location.href = "/";
                            break;
                    }
                    call(response.object);
                });
            };


### Regex를 통한 유효성 체크

### SERVER

    @Table
    public class User {
        @Key(AUTO_INCREMENT = true)
    	private Integer userId;
    
    	@Column(function = { "index", "unique" })
    	@RegularExpression("{3,}")
    	private String stringId;
    	@RegularExpression("{8,}")
    	private String password;
    	@RegularExpression("\\w+@\\w+\\.\\w+")
    	private String email;
    	private String name;
    	private Integer representiveCardId;
    	private String authcode;
    }
    
### Client

    $scope.check = {
            email: function () {
                if ($user.email == undefined)
                    return true;
                var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
                return regex.test($user.email);
            },
            password: function () {
                if ($user.password == undefined)
                    return true;
                return /^[\w\W]{6,}$/i.test($user.password);
            },
            name: function () {
                if ($user.name == undefined)
                    return true;
                return /^[\w\W]{2,}$/i.test($user.name);
            },
            gender: function () {
                if ($user.gender != undefined)
                    return true;
                return false;
            },
        };


## 자체적인 library제작 및 활용
DAO library를 통해, 생산성 향상.
기본적인 sql query를 작성하는 시간을 줄임.
서버 측 로직의 단순화

    @Autowired
	DAO dao;
	
	@RequestMapping("/api/auth")
	public Object confirm(User user) {
		User findedUser = dao.find(user, "stringId");
		if (findedUser == null)
			return Result.getErrorSearchNotFound();
		if (!findedUser.getAuthcode().equals(user.getAuthcode()))
			return Result.getErrorBadRequest();
		user.setAuthcode("1");
		
		if (!dao.update(user))
			return Result.getErrorSqlExcute();
		return "redirect:/";
	}

    @Autowired
    DAO dao;

	@RequestMapping(method = RequestMethod.GET)
	public Response get(User user) {
		User u = dao.find(user);
		Card card = new Card(u.getRepresentiveCardId());
		Card c = dao.find(card);
		return Result.getSuccess(c);
	}
### [CF.next-jdbc-mysql library](https://github.com/zerohouse/next-jdbc-mysql)


## 프로젝트에서 가장 잘 한 점
# 서로 불편하지 않다는 점
개성 넘치고 자아가 강한 팀원들이 협업이 무엇인가에 대해 생각하기 시작함<br><br>
팀원 모두 개성이 강하고, 상대방의 다른 성향들을 알고있어서 서로 매우 조심스러웠음
“욕나올 정도로 싸워야 발전한다”는건 알지만 쉽지 않아 속마음을 드러내기 어려워함
학기 중반이 지나고 지속적인 회고를 통해 서로의 마음을 진실되게 ‘이해’하기 시작함
최종회고 때, 팀원들이 소중하고 팀이 너무 좋아서 아쉬움이 많이 남기도 함 (ㅠㅠㅠㅠ)


## 가장 어려웠던 점

#2주 정도 서로 아무 말도 하지 않음


잘 진행되고 있던 프로젝트를 중단하고 새로운 프로젝트를 시작함
빠른 속도로 개발을 진행해 이미 많은 부분이 완성 된 프로젝트를 갈아 엎음.
학기의 반이 지난 시점에서 프로젝트를 엎는 경험을 해봄


좀 더 임팩트 있는 결과물에 대한 아쉬움
뛰어난 웹 서버 코딩실력과 어마어마한 작업량에도 아무런 부하를 느끼지 않는 성호, 뛰어난 코딩실력에 잘 해내 고 싶다는 열정과 의지를 가지고 있으며 할 말은 똑부러지게 하고 넘어가는 부용, 웹UI 코딩의 거의 전부를 담당하 면서도 묵묵히 할 일을 해내고 매사에 별다른 불만이 없이 사람들과 잘 융화되는 우림, 번뜩이는 통찰력과 분위기 를 부드럽게 만드는 재주를 가지고 있던 도호!
각자 개성이 뚜렷한 만큼 잘 뭉치기만 한다면 마스터피스를 만들 수 있었는데… 하는 아쉬움이 남음

신중하지 못했던 의사결정
처음 아이템 선정을 할 때, 남자들의 막무가내식 넉살로 이루어짐
이후에 회의를 할 때도 의견이 나오면 “네 그럽시다”하고 마쳤다가, 회의가 끝나고 아까 너무 날림으로 정한거 아니냐며 다시 소집을 하는게 주 패턴이 됨
항상 소집을 하는 사람도 민망하고 회의의 효율성도 떨어짐.

