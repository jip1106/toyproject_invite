let boolDupId = false;
let boolIdLength = false;
let boolPassword = false;

$(function(){
    //아이디 중복체크
    $("#memberId").on("keyup",function(){
        let memberId = $(this).val();
        const alarmTag = $(this).siblings("p");

        if(memberId != ""){

            if(memberId.length <6 || memberId.length >15){
                alarmTag.removeClass("none");
                alarmTag.addClass("show");
                alarmTag.removeClass("alarm_g");
                alarmTag.addClass("alarm_r");
                alarmTag.text("아이디는 6이상 ~15글자 이하로 입력 해주세요.");

                if(memberId.length > 15){
                    $(this).val(memberId.substring(0,15));
                    changeBoolIdLength(true);
                    getDupCheck($(this).val(),alarmTag);
                }else{
                    changeBoolIdLength(false);
                }
            }else{

                getDupCheck(memberId,alarmTag);
            }
        }
    });

    //패스워드 비교
    $("input[type='password']").on("keyup", function(){
        const element = $(this);
        let inputVal = element.val();
        let tagId = element.attr("id");

        const compareElement = (tagId === 'password') ? $("#passwordConfirm") :  $("#password");
        let compareVal = compareElement.val();

        if(isNotNull(compareVal) ){
            if(inputVal !== compareVal){
                element.css("border","1px solid rgba(255, 0, 0, 0.5)");
                //compareElement.css("border","1px solid rgba(255, 0, 0, 0.5)");
                changeBoolPwd(false);
            }else{
                element.css("border","1px solid rgba(0, 0, 0, 0.15)");
                compareElement.css("border","1px solid rgba(0, 0, 0, 0.15)");
                changeBoolPwd(true);
            }
        }

    });

    //회원 가입 버튼 클릭
    $(".actions > li > input.submit_btn").on("click", function(){
        if(validCheck()){
            signup();
        }
    });
});


/* 회원가입 요청 정보(form) */
function getFrmMemberData(){
    const frm = document.querySelector('[name="frm"]');

    let rtnData = {
        memberId : frm.memberId.value,
        password : frm.password.value,
        name : frm.name.value,
        email : frm.email.value
    };

    return rtnData;
}

//회원 가입 유효성 검사
function validCheck(){
    const frm = document.querySelector('[name="frm"]');

    const memberId = frm.memberId.value;
    const password = frm.password.value;
    const name = frm.name.value;
    const email = frm.email.value;

    if(isNull(memberId)){
        alert("회원 아이디를 입력 해주세요.");
        return false;
    }

    if(!boolIdLength){
        alert("id는 6이상, 15글자 이하로 입력 해주세요.")
        return false;
    }

    if(!boolDupId){
        alert("중복된 회원 아이디 입니다.");
        return false;
    }


    if(isNull(password)){
        alert("비밀번호를 입력 해주세요.");
        return false;
    }

    if(!boolPassword){
        alert("비밀번호와 비밀번호 확인 값이 다릅니다.");
        return false;
    }

    if(isNull(name)){
        alert("이름을 입력 해주세요.");
        return false;
    }


    return true;
}

//api 호출 id 중복 확인
async function getDupCheck(paramMemberId,obj){

    changeBoolIdLength(true);
    const count = await dupCheck(paramMemberId);

    if(count == 0){
        obj.removeClass("alarm_r");
        obj.addClass("alarm_g");
        obj.text("사용가능한 아이디 입니다.");
        changeBoolId(true);
    }else{
        obj.removeClass("alarm_g");
        obj.addClass("alarm_r");
        obj.text("중복된 아이디 입니다.");
        changeBoolId(false, "");
    }
}

//회원 가입 버튼 클릭
async function signup(){
    const memberData = getFrmMemberData();

    addMember(memberData).then(
        (response) => {
            //회원가입 성공
            console.log(response);
            const rtnUrl = new URL('/user/signup/result',location);

            rtnUrl.searchParams.append('seq', response.memberSeq);
            rtnUrl.searchParams.append('id', response.memberId);

            location.href = rtnUrl.href;
        },
        (errorResponse) => {
            //회원가입 실패
            console.log(response);
            const rtnUrl = new URL('/user/signup/result',location);
            rtnUrl.searchParams.append('message', errorResponse.message);

            location.href = rtnUrl.href;
        }
    );
}



//체크값 변경
const changeBoolId = (value) =>{
    if(isNotNull(value)){
        boolDupId = value;
    }
}

const changeBoolIdLength = (value) =>{
    if(isNotNull(value)){
        boolIdLength = value;
    }
}

const changeBoolPwd = (value) =>{
    if(isNotNull(value)){
        boolPassword = value;
    }
}
