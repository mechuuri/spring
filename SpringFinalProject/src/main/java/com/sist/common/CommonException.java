package com.sist.common;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
/*
 * 	스프링 : 객체 생성 ~ 소멸 (필요시마다 호출이 가능 => 기본 싱글턴) => 핵심만 코딩
 * 	1. 메모리 할당 (제외: VO (사용자 정의 데이터형), Mapper(인터페이스)) => 기능별로 분리해서 저장 
 * 		@Component => OpenAPI (일반 클래스)
 * 		@Repository => DAO (저장소 : 데이터베이스 관련)
 * 		@Service => DAO가 여러개인 경우(Join, SubQuery...)
 * 		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 1. 서비스와 DAO의 차이점?
 * 		@Controller : 브라우저와 연결 (DispatcherServlet이 위임) : 파일명 (화면 이동)
 * 		@RestController : 다른 프로그램과 연결 (자바스크립트와 연결,Kotlin연결) => JSON / JSONP
 * 		@ControllerAdvice : Controller에서 공통 예외처리 
 * 		@RestControllerAdvice : RestController에서 공통 예외처리
 * 		@Configuration : 자바로 환경설정 할 때 (스프링 셋팅)
 * 2. 주입
 * 	  일반 문자열 주입 => @Value
 * 	  클래스 객체 주소 주입 => @Autowired, @Resource(多), @Qualifier
 * 									 ----------------------- 특정 객체 지정
					  => @Autowired + @Qualifier = @Resource
					  => @Qualifier("id명"), @Resource(name="id명") => JDK1.8
	
	=> DI / AOP / Transaction
	=> 자바
		캡슐화 | 은닉화
		상속 | 포함
		오버로딩 | 오버라이딩
		추상클래스 | 인터페이스
		객체가 뭐냐
		예외처리의 종류 (예외 복구 / 예외 회피)
		컬렉션의 종류 (List,Map,Set)
							---- 이중 for
		쓰레드 부분
	=> 오라클
		=> JOIN / SUBQuery / View sql문장이 길거나 보안이 필요할 떄?
		=> Index(언제 쓰는지...******)
		=> Procedure | Function | Trigger
		=> 데이터형 (多: BLOB, BFILE) > 동영상, 이미지 저장
					바이너리   파일형태  : 폴더형태로 들어갔다 
	=> HTML / CSS
	   시멘택 태그 (찾기 쉽게..) / GET / POST
	=> JSP
	   GET / POST
	   Cookie / Session
	   MVC
	=> Front END : VueJS / ReactJS 차이점 => 장/단점
	   자바스크립트 : var / let / const, Arrow함수, 클로저 => ajax/axios
	=> 프로젝트 => 인성 면접 (자기소개서)
 * 
 */
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
/*
 * 	1. RuntimeException : NumberFormatException / NullPointerException / ClassCastException
 * 	2.
 * 	3.
 * 	4.
 */
public class CommonException {
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException ex)
	{
		System.out.println("================runtimeException==============");
		System.out.println(ex.getMessage());
		System.out.println("==============================================");
	}
	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException ex)
	{
		System.out.println("================sqlException==============");
		System.out.println(ex.getMessage());
		System.out.println("==============================================");
	}
	@ExceptionHandler(IOException.class)
	public void ioException(IOException ex)
	{
		System.out.println("================ioException==============");
		System.out.println(ex.getMessage());
		System.out.println("==============================================");
	}
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex)
	{
		System.out.println("================Exception==============");
		System.out.println(ex.getMessage());
		System.out.println("==============================================");
	}
}
