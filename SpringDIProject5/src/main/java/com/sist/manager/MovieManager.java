package com.sist.manager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.vo.*;
import java.io.*;
import java.net.*;
/*
 * 	어노테이션
 * 	--------
 *  = 메모리 할당 (객체생성)
 *  	@Component
 *  		|
 *  ----------------------------------------------------------------------------------
 *  |			 |			  |			       |			       |
 *  @repository	 @service	  @Controller    @RestController	@ControllerAdvice
 *  =================================> 기능별로 구분
 *  @repository : DAO 클래스를 알려준다
 *  @Service : BI (DAO여러개를 묶어서 사용)
 *  @Controller : Model (화면 전환)
 *  @RestController : Model (데이터 전송)
 *  ------ 다른 프로그램과 연동 (Front : Ajax, Vue, React) = JSON
 *  @ControllerAdvice : 공통 예외처리
 *  -------------------------------------------------------- 웹
 * 	= 주입
 * 	@Qualifier : 특정 객체를 지정
 * 	@Inject : 주입
 * 	@Autowired : 자동 주입 => 스프링에 의해서 객체를 찾아서 자동으로 메모리 주소를 넘겨준다
 * 	  private A a;
 * 	  public void setA(A a)
 * 	  {
 * 	  }
 * 	  ------------------------ p:a-ref (수동)
 * 	@Autowired
 * 	private A a;
 * 	-------------------------- 메모리 할당이 아니라 주입(DI와 관련)
 * 	@PostConstructor : init-method
 * 	@PreDestroy : destroy-method
 * 	= 공통모듈 : AOP
 * 	@Aspect
 * 		@Before
 * 		@After
 * 		@Around
 * 		@After-Retruning
 * 		@After-Throwing
 */
//https://www.kobis.or.kr/kobis/business/main/main.do
@Component("mm") // 스프링에서 관리 요청 (객체 생성 => DI => 객체 소멸) => 메모리 할당 (DL => 자동으로 id가 생성 )
public class MovieManager {
	
	public static void main(String[] args) {
		MovieManager m=new MovieManager();
		List<MovieVO> list=m.movieListData(1);
		for(MovieVO vo:list)
		{
			System.out.println(vo.getRank()+" "+vo.getTitle()+" "+vo.getGenre()+" "+vo.getDirector());
		}
		m.movieListData(1);
	}
	private String[] Url={"","searchMainDailyBoxOffice.do","searchMainRealTicket.do",
			"searchMainDailySeatTicket.do","searchMainOnlineDailyBoxOffice.do"};
	public List<MovieVO> movieListData(int no)
	{
		List<MovieVO> list=new ArrayList<MovieVO>();
		/*try
		{
			URL url=new URL("https://www.kobis.or.kr/kobis/business/main/"+strUrl[no]);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			if(conn!=null)
			{
				BufferedrReader br=
						new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while(true)
				{
					String data=br.readLine();
					if(data==null) break;
					System.out.println(data);
				}
			}
		}catch(Exception ex) {}*/
		try
		{
			Document doc=Jsoup.connect("https://www.kobis.or.kr/kobis/business/main/"+Url[no]).get();
			String data=doc.toString();
			data=data.substring(data.indexOf("["), data.lastIndexOf("]")+1);
			data=data.replace("<", "");
			data=data.replace(">", "");
			System.out.println(data);
			
			JSONParser jp=new JSONParser();
			JSONArray arr=(JSONArray)jp.parse(data);
			
			for(int i=0;i<arr.size();i++)
			{
				JSONObject obj=(JSONObject)arr.get(i); // 배열안에 들어간 값을 하나씩 가지고 옴
				MovieVO vo=new MovieVO();
				String rank=String.valueOf((long)obj.get("rank"));
				vo.setRank(Integer.parseInt(rank));
				vo.setTitle((String)obj.get("movieNm"));
				vo.setDirector((String)obj.get("director"));
				vo.setGenre((String)obj.get("genre"));
				list.add(vo);
			}
		}catch(Exception ex) {}
		
		return list;
	}
	
}
