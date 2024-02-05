$(function(){
    //로그인 버튼 클릭
    $("ul.actions > li > input.submit_btn").on("click", function(){
        if(loginValidCheck()){
            login();
        }
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
            location.href = "/";
        },
        (err) => {
            console.log(err);
            switch(err.status){
            case 401 : alert(err.responseText); break;
            case 500 : alert(err.responseJSON.message);break;
            }


        }
    );

}


