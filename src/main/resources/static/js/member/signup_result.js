$(function(){
     const queryParams = new URLSearchParams(window.location.search);

    // seq, id
    let seq = queryParams.get('seq');
    let id = queryParams.get('id');

    getMemberDetail(seq, id).then(
        (res) => {
            console.log(res);
            console.log(res.memberId);
            console.log(res.name);
            console.log(res.createdAt);
            console.log(res.message);

            $("#message").text(res.name + "님 " + res.message);
            $("#info").text("아이디 : " + res.memberId);
            $("#dateInfo").text("가입날짜 : " + res.createdAt);

        },(err) =>{
            $("#message").text(err.responseJSON.message);

        }
    );


});







