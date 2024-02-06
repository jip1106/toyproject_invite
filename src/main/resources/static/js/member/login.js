$(function(){
    //로그인 버튼 클릭
    $("ul.actions > li > input.submit_btn").on("click", function(){
        if(loginValidCheck()){
            login();
        }
    });

    //회원가입 페이지로 이동
    $("ul.actions > li > input.signup").on("click", function(){
        location.href = "/member/signup";
    });

});


function loginValidCheck(){
    let memberId = $("#memberId").val();
    let password = $("#password").val();

    if(isNull(memberId)){
        alert("아이디를 입력 해주세요.");
        return false;
    }

    if(isNull(password)){
        alert("비밀번호를 입력 해주세요.");
        return false;
    }

    return true;
}

async function login(){
    let paramMemberId = $("#memberId").val();
    let paramPassword = $("#password").val();

    const loginParam = {
        memberId : paramMemberId,
        password : paramPassword
    };


    doLogin(loginParam).then(
        (res) => {
            console.log(res);
            //로그인 완료 후 메인페이지로 이동
            location.href = "/";
        },
        (err) => {
            console.log(err);
            alert(err.responseText);
        }
    );

}


