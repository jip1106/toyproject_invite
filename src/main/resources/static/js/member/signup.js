
$(function(){
    //아이디 중복체크 로직
    $("#memberId").on("keyup",function(){
        let memberId = $(this).val();
        const alarmTag = $(this).siblings("p");

        //id 중복 체크 로직
        if(memberId != ""){
            getDupCheck(memberId,$(this));
        }


    });
});

//dupApiCheck api 호출 중복 체크
async function getDupCheck(paramMemberId,obj){
    const count = await dupApiCheckApi(paramMemberId);

    let inputLen = obj.val().length;
    let selectedTag = obj.siblings("p");


    if(inputLen <6 || inputLen >15){
        selectedTag.removeClass("none");
        selectedTag.addClass("show");
        selectedTag.removeClass("alarm_g");
        selectedTag.addClass("alarm_r");
        selectedTag.text("아이디는 6이상 ~15글자 이하로 입력 해주세요.");
    }else{
        if(count == 0){
            selectedTag.removeClass("alarm_r");
            selectedTag.addClass("alarm_g");
            selectedTag.text("사용가능한 아이디 입니다.");
        }else{
            selectedTag.removeClass("alarm_g");
            selectedTag.addClass("alarm_r");
            selectedTag.text("중복된 아이디 입니다.");
        }
    }

}
