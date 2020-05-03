window.addEventListener("load", function() {
	const userInfoForm = document.querySelector("#userInfoForm");
	const schoolType = userInfoForm.querySelector("#schoolType");
	const major = userInfoForm.querySelector("#major");

	const schoolTypeOfMajor = {
		신학대학 : {
			major : [ "신학부" ]
		},
		인문대학 : {
			major : [ "영어영문학과", "중어중문학과", "국어국문학과" ]
		},
		사회과학대학 : {
			major : [ "사회복지학과", "국제개발협력학과", "행정학과" ]
		},
		사범대학 : {
			major : [ "유아교육과", "체육교육과", "교직부" ]
		},
		예술대학 : {
			major : [ "음악학부", "연극영화학부", "뷰티디자인학과", "공연음악예술학부" ]
		},
		파이데이아칼리지 : {
			major : [ "파이데이아학부" ]
		},
		융합대학 : {
			major : [ "융합학부" ]
		},
		글로벌경영기술대학 : {
			major : [ "관광개발학부", "경영학과", "동아시아물류학부", "산업경영공학과" ]
		},
		IT공학대학 : {
			major : [ "컴퓨터공학과", "정보통신공학과", "미디어소프트웨어학과", "도시디자인정보공학과" ]
		}
	};

	// change 이벤트 추가
	schoolType.addEventListener("change", function(e) {
		const key = e.target.value;
		const majors = schoolTypeOfMajor[key].major
		major.innerHTML = ""; // 전공 초기화
		for (let i = 0; i < majors.length; i++) {
			var option = document.createElement('option');
			option.append(majors[i]);
			major.appendChild(option);
		}

	})

	// 대학&전공 초기화
	function schoolTypeAndMajorInit() {
		const schoolTypes = Object.keys(schoolTypeOfMajor);
		const majors = schoolTypeOfMajor[`${user.schoolType}`].major;
		// 대학 초기화
		for (let i = 0; i < schoolTypes.length; i++) {
			var option = document.createElement('option');
			option.append(schoolTypes[i]);
			if (schoolTypes[i] === `${user.schoolType}`) {
				option.selected = true;
			}
			schoolType.append(option);
		}
		// 전공 초기화
		for (let i = 0; i < majors.length; i++) {
			var option = document.createElement('option');
			option.append(majors[i]);
			if (majors[i] === `${user.major}`) {
				option.selected = true;
			}
			major.appendChild(option);
		}
	}
	schoolTypeAndMajorInit();

})