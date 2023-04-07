<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 1300px;
}
h1{
   text-align: center;
}
.details:hover{
   cursor: pointer;
}
</style>
</head>
<body>
<div class="wrapper row3 rows">
  <main class="container clear"> 
    <div class="row">
      <table class="table">
        <tr>
          <th width=20% class="inline" style="color:black">아이디</th>
          <td width=80%>
           <input type=text ref="id" v-model="id" size=20 class="input-sm" v-bind:disabled="isDis">
           <input type=button value="아이디중복체크" class="btn btn-sm btn-danger" v-on:click="idCheck()">
          </td>
        </tr>
        <tr>
          <th width=20% class="inline" style="color:black">비밀번호</th>
          <td width=80%>
           <input type=password ref="pwd" v-model="pwd" size=20 class="input-sm">
          </td>
        </tr>
        <tr>
          <th width=20% class="inline" style="color:black">이름</th>
          <td width=80%>
           <input type=text ref="name" v-model="name" size=20 class="input-sm">
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <input type=button value="회원가입" class="btn btn-sm btn-info" v-on:click="memberjoin()">
            <input type=button value="로그인" class="btn btn-sm btn-warning" onclick="javascript:history.back()">
          </td>
        </tr>
      </table>
    </div>
  </main>
</div>
<script>
	new Vue({
		el:'.rows',
		data:{
			id:'',
			pwd:'',
			name:'',
			msg:'',
			isDis:false
		},
		// mounted 시작하자마자 처리.. 상세보기
		// 버튼 누를때마다 처리 > methods
		methods:{
			idCheck:function(){
				if(this.id==='')
				{
					this.$refs.id.focus()
					return 
				}
				let _this=this
				axios.get('http://localhost/web/member/idcheck_vue.do',{
					params:{
						id:this.id
					}
				}).then(function(response){
					let result=response.data
					if(result==='yes')
					{
						alert(this.id+"는 사용 가능한 ID입니다")
						_this.idDis=true
					}
					else
					{
						alert(this.id+"는(은) 이미 사용중인 ID입니다");
						_this.id=''
						_this.$refs.id.focus()
					}
					
				})
			},
			memberJoin:function(){
				if(this.id==="")
				{
					alert("아이디 중복체크버튼을 클릭하세요")
					this.$refs.id.focus();
					return;
				}
				if(this.pwd==="")
				{
					this.$refs.pwd.focus();
					return 
				}
				if(this.name==="")
				{
					this.$refs.name.focus();
					return
				}
				let _this=this
				axios.get('http://localhost/web/member/insert_vue.do',{
					params:{
						id:_this.id,
						pwd:_this.pwd,
						name:_this.name
					}
				}).then(function(response){
					let result=response.data
					if(result==="yes")
					{
						alert(_this.id+"님 회원가입되었습니다")
						location.href="../main/main.do"
					}
					else
					{
						alert("회원 가입에 실패하였습니다")
						_this.isDis=false;
						_this.id='';
						_this.pwd='';
						_this.name='';
						_this.$refs.id.focus()
					}
				})
			}
		}
	})
</script>
</head>
<body>

</body>
</html>