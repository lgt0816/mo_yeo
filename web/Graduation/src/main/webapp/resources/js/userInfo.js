window.addEventListener("load", function() {
	const userInfoForm = document.querySelector("#userInfoForm");
	const changeUserPwBtn = userInfoForm.querySelector("#change-userPw-btn");
	const modifyBtn = userInfoForm.querySelector("#modify");
	const cancelBtn = userInfoForm.querySelector("#cancel");
	
	//수정하기버튼 클릭이벤트 추가
	modifyBtn.addEventListener("click", function(){
		if(pwCheck()){
			userInfoForm.action = "/userUpdate.do";
			userInfoForm.submit();
		}
	})
	
	//취소하기버튼 클릭이벤트 추가
	cancelBtn.addEventListener("click", function(){
		window.history.back();
	})
	
	//비밀번호 변경하기 버튼 클릭
	changeUserPwBtn.addEventListener("click", function(){
		const newPw = userInfoForm.querySelector("#newPw");
		if(pwCheck() && newPw.value !==""){
			userInfoForm.action = "/userUpdatePw.do";
			userInfoForm.submit();
		}
	});
	
	//비밀번호 체크
    function pwCheck(){
        const userPw1 = userInfoForm.querySelector("#userPw1");
        const userPw2 = userInfoForm.querySelector("#userPw2");
        if(userPw1.value==="" || userPw2.value===""){
            alert("비밀번호를 입력해주세요.");
            return false;
        }else if(userPw1.value !== userPw2.value){
            alert("비밀번호가 일치하지 않습니다.");
            return false;
        }
        return true;
    }

})